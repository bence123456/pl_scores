package bkonecsni.plsocers.ui.favouritematches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;

public class FavouriteMatchesActivity extends AppCompatActivity implements FavouriteMatchesScreen{

    @Inject
    FavouriteMatchesPresenter favouriteMatchesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favouritematches);

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
