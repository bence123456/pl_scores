package bkonecsni.plsocers;

import android.app.Application;

import bkonecsni.plsocers.ui.UIModule;

public class PlScoresApplication extends Application {

    public static PlScoresApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerPlScoresApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
