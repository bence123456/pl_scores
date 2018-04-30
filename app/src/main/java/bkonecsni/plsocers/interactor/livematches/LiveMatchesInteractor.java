package bkonecsni.plsocers.interactor.livematches;

import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.api.Fixtures;
import bkonecsni.plsocers.model.api.Table;
import bkonecsni.plsocers.model.api.Team;
import bkonecsni.plsocers.network.FootballDataApi;
import retrofit2.Call;
import retrofit2.Response;

import static bkonecsni.plsocers.interactor.InteractorModule.COMPETITION_ID;

public class LiveMatchesInteractor {

    @Inject
    FootballDataApi footballDataApi;

    public LiveMatchesInteractor() {
        PlScoresApplication.injector.inject(this);
    }

    public void getLiveMatches() {

        Thread thread = new Thread(new Runnable(){
            public void run() {
                try {
//                    Call<Fixtures> fixturesCall = footballDataApi.listFixtures(COMPETITION_ID);
//                    Response<Fixtures> execute = fixturesCall.execute();
//                    Fixtures body = execute.body();
//                    List<Fixture> fixtureList = body.getFixtures();

                    Call<Table> tableCall = footballDataApi.getLeagueTable(COMPETITION_ID);
                    Response<Table> execute2 = tableCall.execute();
                    Table body2 = execute2.body();
                    List<Team> teamList = body2.getStanding();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
