package bkonecsni.plsocers.ui.livetable;

import javax.inject.Inject;

import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import bkonecsni.plsocers.ui.Presenter;

public class LiveTablePresenter extends Presenter<LiveTableScreen> {

    @Inject
    LiveTableInteractor liveTableInteractor;

    public void refreshTable() {
        liveTableInteractor.getLiveTable();
    }
}
