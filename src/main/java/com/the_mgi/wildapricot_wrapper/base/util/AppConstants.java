package com.the_mgi.wildapricot_wrapper.base.util;

import okhttp3.MediaType;

public class AppConstants {
    public static final String WA_TOKEN_URL = "https://oauth.wildapricot.org/auth/token";
    public static final String WA_MEMBER_API_URL = "https://api.wildapricot.org/v2.2/";
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
}
