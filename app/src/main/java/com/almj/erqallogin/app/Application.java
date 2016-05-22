package com.almj.erqallogin.app;

/**
 * ErqalLogin_MD -- Created by almj on 16/5/21.
 * Author-URl: www.teshna.me
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Override the App font with Uighur font ttf
        FontsOverride.setDefaultFont(this, "MONOSPACE", "UKIJTuzTom.ttf");
    }
}
