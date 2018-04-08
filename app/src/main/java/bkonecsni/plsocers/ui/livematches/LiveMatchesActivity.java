package bkonecsni.plsocers.ui.livematches;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import bkonecsni.plsocers.db.DbConstants;

public class LiveMatchesActivity extends AppCompatActivity implements LiveMatchesScreen {

    @Inject
    LiveMatchesPresenter liveMatchesPresenter;

    @Override
    public void showLiveMatches() {
        liveMatchesPresenter.refreshMatches();
    }

    @Override
    public void addMatchToFavourites(DbConstants.FavouriteMatch favouriteMatch) {
        liveMatchesPresenter.addFavouriteMatch(favouriteMatch);
    }

}
