package bkonecsni.plsocers.ui.livematches;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class LiveMatchesActivity extends DrawerActivity implements LiveMatchesScreen {

    @Inject
    LiveMatchesPresenter liveMatchesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_livematches, R.string.actual_matches);

        PlScoresApplication.injector.inject(this);

        Button refreshMatches = (Button) findViewById(R.id.btnRefreshMatches);
        refreshMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveMatchesPresenter.refreshMatches();
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
    public void showLiveMatches(List<Fixture> fixtures) {
//        liveMatchesPresenter.refreshMatches();
    }

    @Override
    public void addMatchToFavourites(FavouriteMatch favouriteMatch) {
        liveMatchesPresenter.addFavouriteMatch(favouriteMatch);
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

}
