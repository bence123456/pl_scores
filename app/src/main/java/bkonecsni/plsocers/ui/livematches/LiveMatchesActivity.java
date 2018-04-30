package bkonecsni.plsocers.ui.livematches;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.db.FavouriteMatch;

public class LiveMatchesActivity extends AppCompatActivity implements LiveMatchesScreen {

    @Inject
    LiveMatchesPresenter liveMatchesPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livematches);

        PlScoresApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        liveMatchesPresenter.attachScreen(this);
        showLiveMatches();
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveMatchesPresenter.detachScreen();
    }

    @Override
    public void showLiveMatches() {
        liveMatchesPresenter.refreshMatches();
    }

    @Override
    public void addMatchToFavourites(FavouriteMatch favouriteMatch) {
        liveMatchesPresenter.addFavouriteMatch(favouriteMatch);
    }

}
