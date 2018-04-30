package bkonecsni.plsocers.interactor.livetable;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.network.FootballDataApi;

import static bkonecsni.plsocers.interactor.InteractorModule.COMPETITION_ID;

public class LiveTableInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public LiveTableInteractor() {
        PlScoresApplication.injector.inject(this);
    }

    public void getLiveTable() {
        footballDataApi.getLeagueTable(COMPETITION_ID);
    }
}
