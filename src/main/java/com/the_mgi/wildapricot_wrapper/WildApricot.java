package com.the_mgi.wildapricot_wrapper;

import com.the_mgi.wildapricot_wrapper.account.AccountService;
import com.the_mgi.wildapricot_wrapper.base.util.AuthenticationOption;
import com.the_mgi.wildapricot_wrapper.contact.ContactService;
import com.the_mgi.wildapricot_wrapper.contact.saved_search.SavedSearchService;
import lombok.Getter;

@Getter
public class WildApricot {
    private String clientId;
    private String clientSecret;
    private String apiKey;
    private String username;
    private String password;
    private final AuthenticationOption authOption;

    private AccountService accountService;
    private ContactService contactService;
    private SavedSearchService contactSavedSearch;

    private WildApricot(
        AuthenticationOption authOption,
        String apiKey
    ) {
        this.authOption = authOption;
        this.apiKey = apiKey;
        init();
    }

    private void init() {
        contactService = new ContactService(this);
        contactSavedSearch = new SavedSearchService(this);
        accountService = new AccountService(this);
    }

    public WildApricot clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public WildApricot clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public WildApricot apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    @Override
    public String toString() {
        return "WildApricotService{" +
            ", authOption=" + authOption +
            '}';
    }

    public static class Builder {
        private String clientId;
        private String clientSecret;
        private String apiKey;
        private AuthenticationOption authOption;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder authOption(AuthenticationOption authOption) {
            this.authOption = authOption;
            return this;
        }

        public WildApricot build() {
            if (this.authOption == null) throw new NullPointerException("AuthOption parameter cannot be null");
            return switch (this.authOption) {
                case USING_API_KEY -> {
                    if (this.apiKey == null) throw new NullPointerException("ApiKey cannot be null");
                    yield new WildApricot(
                        AuthenticationOption.USING_API_KEY,
                        this.apiKey
                    );
                }
                default -> null;
            };
        }
    }
}
