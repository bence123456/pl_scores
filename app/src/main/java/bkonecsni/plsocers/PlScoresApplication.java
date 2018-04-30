package bkonecsni.plsocers;

import com.orm.SugarApp;

import bkonecsni.plsocers.ui.UIModule;

public class PlScoresApplication extends SugarApp {

    public static PlScoresApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerPlScoresApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
