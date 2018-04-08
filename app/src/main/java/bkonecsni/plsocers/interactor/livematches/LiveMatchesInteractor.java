package bkonecsni.plsocers.interactor.livematches;

import javax.inject.Inject;

import bkonecsni.plsocers.network.FootballDataApi;

public class LiveMatchesInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public void getLiveMatches() {
        int actualMatchday = 0;
        footballDataApi.listFixtures(actualMatchday);
    }
}
