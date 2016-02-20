package com.jeff.michael.heesung.lrn;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by jeff on 2/19/16.
 */
public class ParseApplication extends Application {

    public ParseApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
        ParseUser.enableAutomaticUser();


    }
}
