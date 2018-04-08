package bkonecsni.plsocers.ui.main;

import bkonecsni.plsocers.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    public void startLiveMatchesActivity() {
        screen.showLiveMatches();
    }
}
