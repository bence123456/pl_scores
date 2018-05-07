package bkonecsni.plsocers.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.api.Fixtures;
import bkonecsni.plsocers.model.api.Result;
import bkonecsni.plsocers.model.api.Table;
import bkonecsni.plsocers.model.api.Team;
import bkonecsni.plsocers.network.FootballDataApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockFootballDataApi implements FootballDataApi {
    @Override
    public Call<Fixtures> listFixtures(Long compId, String timeFrame) {
        final Fixtures fixtures = new Fixtures();
        List<Fixture> fixtureList = new ArrayList<>();
        Fixture fixture = new Fixture();
        fixture.setDate("2018-01-07-08T20:00:00Z");
        fixture.setHomeTeamName("Arsenal");
        fixture.setAwayTeamName("West Ham");

        Result result = new Result();
        result.setGoalsAwayTeam("0");
        result.setGoalsHomeTeam("4");
        fixture.setResult(result);
        fixtureList.add(fixture);

        fixtures.setFixtures(fixtureList);

        Call<Fixtures> fixturesCall = new Call<Fixtures>() {
            @Override
            public Response<Fixtures> execute() throws IOException {
                return Response.success(fixtures);
            }

            @Override
            public void enqueue(Callback<Fixtures> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Fixtures> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return fixturesCall;
    }

    @Override
    public Call<Table> getLeagueTable(Long compId) {
        final Table table = new Table();
        List<Team> standing = new ArrayList<>();

        Team team = new Team();
        team.setTeamName("Arsenal");
        team.setPoints(60);
        team.setPlayedGames(30);
        team.setWins(20);
        team.setDraws(5);
        team.setLosses(5);
        team.setGoalsAgainst(50);
        team.setGoals(95);
        standing.add(team);

        table.setStanding(standing);


        Call<Table> tableCall = new Call<Table>() {
            @Override
            public Response<Table> execute() throws IOException {
                return Response.success(table);
            }

            @Override
            public void enqueue(Callback<Table> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Table> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return tableCall;
    }

}
