package com.almj.erqallogin.app;

/**
 * materiallogindemo -- Created by mac on 16/5/21.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "MONOSPACE", "UKIJTuzTom.ttf");
    }
}
