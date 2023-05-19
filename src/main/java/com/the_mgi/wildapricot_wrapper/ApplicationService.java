package com.the_mgi.wildapricot_wrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.base.model.AuthResponse;
import com.the_mgi.wildapricot_wrapper.base.model.ErrorObject;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.base.util.AppConstants;
import com.the_mgi.wildapricot_wrapper.base.util.AuthenticationOption;
import com.the_mgi.wildapricot_wrapper.base.util.ObjectMapperSingleton;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import okhttp3.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public final class ApplicationService {
    private static ApplicationService applicationService;
    private static final OkHttpClient client = new OkHttpClient();
    private final AuthResponse authResponse;

    private ApplicationService(AuthResponse authResponse) {
        this.authResponse = authResponse;
    }

    public <T> T execute(
        Request.Builder requestBuilder,
        String url,
        TypeReference<T> type,
        List<Pair<String, String>> queryParams,
        String authorizationBearer
    ) throws HttpException {
        this.createRequestBuilder(url, queryParams, requestBuilder, authorizationBearer);
        try {
            Response response = client.newCall(requestBuilder.build()).execute();
            if (response.body() == null) throw new IllegalStateException("Null response received");
            String responseBodyString = response.body().string();
            if (response.isSuccessful()) {
                return ObjectMapperSingleton.getObjectMapper().readValue(responseBodyString, type);
            } else if (response.code() == 429) {
                Thread.sleep(1000);
                return this.execute(requestBuilder, url, type, queryParams, authorizationBearer);
            } else {
                try {
                    throw new HttpException(
                        response.message(),
                        response.code(),
                        ObjectMapperSingleton.getObjectMapper().readValue(responseBodyString, ErrorObject.class)
                    );
                } catch (Exception e) {
                    throw new HttpException(response.code(), response.message());
                }
            }
        } catch (IOException ioException) {
            throw new HttpException(500, ioException.getMessage());
        } catch (InterruptedException interruptedException) {
            throw new HttpException(500, "Error Occurred while trying to sleep thread because of 429 status code");
        }
    }

    public <T> T execute(
        String url,
        TypeReference<T> type,
        List<Pair<String, String>> queryParams,
        String authorizationBearer
    ) throws HttpException {
        return this.execute(new Request.Builder(), url, type, queryParams, authorizationBearer);
    }

    public <T> T execute(
        String url,
        TypeReference<T> type,
        List<Pair<String, String>> queryParams
    ) throws HttpException {
        return this.execute(new Request.Builder(), url, type, queryParams, null);
    }

    public <T> T execute(
        String url,
        TypeReference<T> type
    ) throws HttpException {
        return this.execute(new Request.Builder(), url, type, Collections.emptyList(), null);
    }

    private void createRequestBuilder(
        String url,
        List<Pair<String, String>> queryParams,
        Request.Builder requestBuilder,
        String authorizationBearer
    ) {
        var resourceUrl = AppConstants.WA_MEMBER_API_URL + url;
        var httpUrl = HttpUrl.Companion.get(resourceUrl);

        if (CollectionUtils.isNotEmpty(queryParams)) {
            var urlBuilder = httpUrl.newBuilder();
            queryParams.stream()
                .filter(it -> StringUtils.isNotEmpty(it.first()) && StringUtils.isNotEmpty(it.second()))
                .forEach(it -> urlBuilder.addQueryParameter(it.first(), it.second()));

            httpUrl = urlBuilder.build();
        }

        requestBuilder
            .url(httpUrl)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer " + (authorizationBearer != null ? authorizationBearer : this.authResponse.getAccessToken()))
            .addHeader("Accept", "application/json");
    }

    public static ApplicationService getInstance(WildApricot wildApricot) {
        if (applicationService == null) {
            if (wildApricot.getAuthOption().equals(AuthenticationOption.USING_API_KEY)) {
                var authorizationHeader = "APIKEY:" + wildApricot.getApiKey();
                var encodedApiKey = "Basic " + DatatypeConverter.printBase64Binary(authorizationHeader.getBytes(StandardCharsets.UTF_8));

                var formBody = new FormBody.Builder()
                    .add("grant_type", "client_credentials")
                    .add("scope", "auto")
                    .add("obtain_refresh_token", "true")
                    .build();

                var request = new Request.Builder()
                    .url(AppConstants.WA_TOKEN_URL)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Authorization", encodedApiKey)
                    .addHeader("Accept", "application/json")
                    .post(formBody)
                    .build();


                applicationService = getApplicationServiceInstance(request);
            } else if (wildApricot.getAuthOption().equals(AuthenticationOption.USING_LOGIN_PASSWORD)) {
                String clientIdAndSecret = wildApricot.getClientId() + ":" + wildApricot.getClientSecret();
                String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(clientIdAndSecret.getBytes(StandardCharsets.UTF_8));

                FormBody formBody = new FormBody.Builder()
                    .add("grant_type", "password")
                    .add("username", wildApricot.getUsername())
                    .add("password", wildApricot.getPassword())
                    .add("scope", "auto")
                    .build();

                Request request = new Request.Builder()
                    .url(AppConstants.WA_TOKEN_URL)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Authorization", authorizationHeader)
                    .addHeader("Accept", "application/json")
                    .post(formBody)
                    .build();

                applicationService = getApplicationServiceInstance(request);

            } else throw new RuntimeException("Authentication is only supported with ApiKey yet!");
        }
        return applicationService;
    }

    private static ApplicationService getApplicationServiceInstance(Request request) {
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            String stringResponse = response.body().string();
            if (response.isSuccessful()) {
                return new ApplicationService(ObjectMapperSingleton.getObjectMapper().readValue(stringResponse, AuthResponse.class));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        throw new RuntimeException("Invalid Exception occurred!");
    }
}
