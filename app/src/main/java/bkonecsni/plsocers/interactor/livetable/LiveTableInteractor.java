package bkonecsni.plsocers.interactor.livetable;

import javax.inject.Inject;

import bkonecsni.plsocers.network.FootballDataApi;

public class LiveTableInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public void getLiveTable() {
        footballDataApi.getTLeagueTable();
    }
}
