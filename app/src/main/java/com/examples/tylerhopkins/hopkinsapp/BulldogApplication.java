package com.examples.tylerhopkins.hopkinsapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Tyler Hopkins on 9/18/2017.
 */

public class BulldogApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();

        Realm.init(this);
    }
}
