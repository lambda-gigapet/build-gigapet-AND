package com.example.gigapet;

public class GigapetDao {
    private static String BASE_URL = "https://lambda-gigapet.herokuapp.com/";
    private static String PET_URL = BASE_URL + "api/pet";
    private static String REGISTER_URL = BASE_URL + "api/auth/register";
    private static String LOGIN_URL = BASE_URL + "api/auth/login";
    private static String CHILD_URL = BASE_URL + "api/child/%d";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getPetUrl() {
        return PET_URL;
    }

    public static String getRegisterUrl() {
        return REGISTER_URL;
    }

    public static String getLoginUrl() {
        return LOGIN_URL;
    }

    public static String getChildUrl() {
        return CHILD_URL;
    }
}
