package bkonecsni.plsocers.ui.livetable;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import bkonecsni.plsocers.ui.Presenter;

public class LiveTablePresenter extends Presenter<LiveTableScreen> {

    @Inject
    LiveTableInteractor liveTableInteractor;

    @Override
    public void attachScreen(LiveTableScreen screen) {
        super.attachScreen(screen);
        PlScoresApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshTable() {
        liveTableInteractor.getLiveTable();
    }
}
