package bkonecsni.plsocers.ui.livematches;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
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
    private List<FavouriteMatch> favouriteMatchList;
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
        liveMatchesAdapter.setOnItemClickListener(new LiveMatchesAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Fixture fixture = fixtureArrayList.get(position);

                if (fixture.isFavourite()) {
                    Toast.makeText(getApplicationContext(), "Please use the Favourite matches screen to remove matches from favourites", Toast.LENGTH_LONG).show();
                } else {
                    FavouriteMatch favouriteMatch = createFavouriteMatchFromFixture(fixture);
                    addMatchToFavourites(favouriteMatch);
                    Toast.makeText(getApplicationContext(), "Match added to favourites!", Toast.LENGTH_LONG).show();
                }

                updateFixtures(liveMatchesPresenter.getFavouriteMatches());
                liveMatchesAdapter.notifyDataSetChanged();
            }
        });
        recyclerViewMatches.setAdapter(liveMatchesAdapter);

        swipeRefreshLayoutMatches = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutTable);
        swipeRefreshLayoutMatches.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                liveMatchesPresenter.refreshMatches();
            }
        });
    }

    private void updateFixtures(List<FavouriteMatch> favouriteMatches) {
        for (Fixture fixture : fixtureArrayList) {
            for (FavouriteMatch favouriteMatch : favouriteMatches) {
                if (isFixtureAndFavMatchSame(fixture, favouriteMatch)) {
                    fixture.setFavourite(true);
                }
            }
        }
    }

    private boolean isFixtureAndFavMatchSame(Fixture fixture, FavouriteMatch favouriteMatch) {
        return fixture.getDate().equals(favouriteMatch.getDate()) && fixture.getHomeTeamName().equals(favouriteMatch.getHomeTeamName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        liveMatchesPresenter.attachScreen(this);
        favouriteMatchList = liveMatchesPresenter.getFavouriteMatches();
        liveMatchesPresenter.refreshMatches();
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveMatchesPresenter.detachScreen();
    }

    @Override
    public void showLiveMatches(List<Fixture> fixtures) {
        if (swipeRefreshLayoutMatches != null) {
            swipeRefreshLayoutMatches.setRefreshing(false);
        }

        fixtureArrayList.clear();
        fixtureArrayList.addAll(fixtures);
        updateFixtures(favouriteMatchList);
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

    private FavouriteMatch createFavouriteMatchFromFixture(Fixture fixture) {
        FavouriteMatch favouriteMatch = new FavouriteMatch();

        favouriteMatch.setDate(fixture.getDate());
        favouriteMatch.setHomeTeamName(fixture.getHomeTeamName());
        favouriteMatch.setAwayTeamName(fixture.getAwayTeamName());

        Result result = fixture.getResult();
        favouriteMatch.setHomeTeamGoals(result == null ? "-" : result.getGoalsHomeTeam());
        favouriteMatch.setAwayTeamGoals(result == null ? "-" : result.getGoalsAwayTeam());

        return favouriteMatch;
    }

}
