package bkonecsni.plsocers.ui.favouritematches;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.livematches.LiveMatchesAdapter;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class FavouriteMatchesActivity extends DrawerActivity implements FavouriteMatchesScreen{

    @Inject
    FavouriteMatchesPresenter favouriteMatchesPresenter;

    private RecyclerView recyclerViewFavouriteMatches;
    private ArrayList<FavouriteMatch> favouriteMatchesArrayList;
    private FavouriteMatchesAdapter favouriteMatchesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_favouritematches, R.string.favourite_matches);

        PlScoresApplication.injector.inject(this);

        recyclerViewFavouriteMatches = (RecyclerView) findViewById(R.id.recyclerViewMatches);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFavouriteMatches.setLayoutManager(llm);

        favouriteMatchesArrayList = new ArrayList<>();
        favouriteMatchesAdapter = new FavouriteMatchesAdapter(getApplicationContext(), favouriteMatchesArrayList);
        recyclerViewFavouriteMatches.setAdapter(favouriteMatchesAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        favouriteMatchesPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        favouriteMatchesPresenter.detachScreen();
    }

    @Override
    public void showFavouriteMatches() {
        List<FavouriteMatch> favouriteMatches = favouriteMatchesPresenter.listFavouriteMatches();

        favouriteMatchesArrayList.clear();
        favouriteMatchesArrayList.addAll(favouriteMatches);
        favouriteMatchesAdapter.notifyDataSetChanged();
    }

    @Override
    public void removeFromFavourites(long rowId) {
        favouriteMatchesPresenter.removeFavouriteMatch(rowId);
    }
}
