package com.codeup.adlister.dao;

/*
ensures that only a single instance of ListAds is ever created
 */

import com.codeup.adlister.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
