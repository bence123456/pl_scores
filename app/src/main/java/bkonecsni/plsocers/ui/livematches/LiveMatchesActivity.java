package bkonecsni.plsocers.ui.livematches;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.api.Result;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class LiveMatchesActivity extends DrawerActivity implements LiveMatchesScreen {

    @Inject
    LiveMatchesPresenter liveMatchesPresenter;

    private RecyclerView recyclerViewMatches;
    private ArrayList<Fixture> fixtureArrayList;
    private LiveMatchesAdapter liveMatchesAdapter;
    private SwipeRefreshLayout swipeRefreshLayoutMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_livematches, R.string.actual_matches);

        PlScoresApplication.injector.inject(this);

        recyclerViewMatches = (RecyclerView) findViewById(R.id.recyclerViewMatches);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMatches.setLayoutManager(llm);

        fixtureArrayList = new ArrayList<>();
        liveMatchesAdapter = new LiveMatchesAdapter(getApplicationContext(), fixtureArrayList);
        recyclerViewMatches.setAdapter(liveMatchesAdapter);

        swipeRefreshLayoutMatches = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutTable);
        swipeRefreshLayoutMatches.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //                liveMatchesPresenter.refreshMatches();
                showLiveMatches(Arrays.asList(
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                        createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", null)
                ));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        liveMatchesPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveMatchesPresenter.detachScreen();
    }

    @Override
    public void onResume() {
        super.onResume();
//        liveMatchesPresenter.refreshMatches();
        showLiveMatches(Arrays.asList(
                createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                createFixture("Newcastle", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                createFixture("Manchester City", "West Bromwich Albion FC", "IN_PLAY", "2014-07-08T20:00:00Z", createResult("0", "1")),
                createFixture("Manchester City", "Arsenal", "IN_PLAY", "2014-07-08T20:00:00Z", null)
        ));
    }

    @Override
    public void showLiveMatches(List<Fixture> fixtures) {
        if (swipeRefreshLayoutMatches != null) {
            swipeRefreshLayoutMatches.setRefreshing(false);
        }

        fixtureArrayList.clear();
        fixtureArrayList.addAll(fixtures);
        liveMatchesAdapter.notifyDataSetChanged();
    }

    @Override
    public void addMatchToFavourites(FavouriteMatch favouriteMatch) {
        liveMatchesPresenter.addFavouriteMatch(favouriteMatch);
    }

    @Override
    public void showNetworkError(String errorMsg) {
        if (swipeRefreshLayoutMatches != null) {
            swipeRefreshLayoutMatches.setRefreshing(false);
        }
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

    private Fixture createFixture(String homeTeamName, String awayTeamName, String status, String date, Result result) {
        Fixture fixture = new Fixture();

        fixture.setHomeTeamName(homeTeamName);
        fixture.setAwayTeamName(awayTeamName);
        fixture.setStatus(status);
        fixture.setDate(date);
        fixture.setResult(result);

        return fixture;
    }

    private Result createResult(String homeTeamGoals, String awayTeamGoals) {
        Result result = new Result();

        result.setGoalsHomeTeam(homeTeamGoals);
        result.setGoalsAwayTeam(awayTeamGoals);

        return result;
    }

}
