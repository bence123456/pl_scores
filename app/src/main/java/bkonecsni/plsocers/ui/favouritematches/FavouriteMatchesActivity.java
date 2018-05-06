package bkonecsni.plsocers.ui.favouritematches;

import android.os.Bundle;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class FavouriteMatchesActivity extends DrawerActivity implements FavouriteMatchesScreen{

    @Inject
    FavouriteMatchesPresenter favouriteMatchesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_favouritematches, R.string.favourite_matches);

        PlScoresApplication.injector.inject(this);
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
        favouriteMatchesPresenter.listFavouriteMatches();
    }

    @Override
    public void removeFromFavourites(long rowId) {
        favouriteMatchesPresenter.removeFavouriteMatch(rowId);
    }
}
