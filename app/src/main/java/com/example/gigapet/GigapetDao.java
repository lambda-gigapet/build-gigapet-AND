package com.example.gigapet;

public class GigapetDao {

    public static String getBaseUrl() {
        return Constants.BASE_URL;
    }

    public static String getPetUrl() {
        return Constants.PET_URL;
    }

    public static String getRegisterUrl() {
        return Constants.REGISTER_URL;
    }

    public static String getLoginUrl() {
        return Constants.LOGIN_URL;
    }

    public static String getChildUrl() {
        return Constants.CHILD_URL;
    }

    public static Gigapet getCurrentGigapet() {
        return GigapetRepo.getCurrentGigapet();
    }

    public static void addGigapet(Gigapet gigapet) {
        GigapetRepo.addGigapet(gigapet);
    }
}
