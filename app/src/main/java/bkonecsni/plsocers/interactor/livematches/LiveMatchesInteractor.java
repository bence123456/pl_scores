package bkonecsni.plsocers.interactor.livematches;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.interactor.common.CommonNetworkInteractor;
import bkonecsni.plsocers.model.api.Fixtures;
import bkonecsni.plsocers.network.FootballDataApi;
import retrofit2.Call;
import retrofit2.Response;

import static bkonecsni.plsocers.interactor.InteractorModule.COMPETITION_ID;
import static bkonecsni.plsocers.interactor.InteractorModule.FILTER_FOR_NEXT_7_DAYS;

public class LiveMatchesInteractor extends CommonNetworkInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public LiveMatchesInteractor() {
        PlScoresApplication.injector.inject(this);
    }

    public void getLiveMatches() {
        GetLiveMatchesEvent event = new GetLiveMatchesEvent();

        try {
            Call<Fixtures> fixturesCall = footballDataApi.listFixtures(COMPETITION_ID, FILTER_FOR_NEXT_7_DAYS);
            Response<Fixtures> response = fixturesCall.execute();

            throwExceptionIfNecessary(response);
            creaateAndPostEvent(event, response, response.body().getFixtures());
        } catch (Exception e) {
            createAndPostErrorEvent(event, e);
        }
    }

}
