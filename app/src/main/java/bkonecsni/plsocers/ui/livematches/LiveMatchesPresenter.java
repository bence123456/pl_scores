package bkonecsni.plsocers.ui.livematches;

import javax.inject.Inject;

import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.ui.Presenter;

public class LiveMatchesPresenter extends Presenter<LiveMatchesScreen> {

    @Inject
    LiveMatchesInteractor liveMatchesInteractor;

    public void refreshMatches() {
       liveMatchesInteractor.getLiveMatches();
    }

}
