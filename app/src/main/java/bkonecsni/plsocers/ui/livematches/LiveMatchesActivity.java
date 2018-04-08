package bkonecsni.plsocers.ui.livematches;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class LiveMatchesActivity extends AppCompatActivity implements LiveMatchesScreen {

    @Inject
    LiveMatchesPresenter liveMatchesPresenter;

    @Override
    public void showLiveMatches() {
        liveMatchesPresenter.refreshMatches();
    }
}
