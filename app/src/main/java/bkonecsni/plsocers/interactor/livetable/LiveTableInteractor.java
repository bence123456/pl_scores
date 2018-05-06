package bkonecsni.plsocers.interactor.livetable;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.interactor.common.CommonNetworkInteractor;
import bkonecsni.plsocers.model.api.Table;
import bkonecsni.plsocers.network.FootballDataApi;
import retrofit2.Call;
import retrofit2.Response;

import static bkonecsni.plsocers.interactor.InteractorModule.COMPETITION_ID;

public class LiveTableInteractor extends CommonNetworkInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public LiveTableInteractor() {
        PlScoresApplication.injector.inject(this);
    }

    public void getLiveTable() {
        GetLiveTableEvent event = new GetLiveTableEvent();

        try {
            Call<Table> tableCall = footballDataApi.getLeagueTable(COMPETITION_ID);
            Response<Table> response = tableCall.execute();

            throwExceptionIfNecessary(response);
            creaateAndPostEvent(event, response, response.body().getStanding());
        } catch (Exception e) {
            createAndPostErrorEvent(event, e);
        }
    }
}
