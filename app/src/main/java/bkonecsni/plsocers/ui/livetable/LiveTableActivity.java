package bkonecsni.plsocers.ui.livetable;

import android.os.Bundle;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class LiveTableActivity extends DrawerActivity implements LiveTableScreen {

    @Inject
    LiveTablePresenter liveTablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_livetable, R.string.standing);

        PlScoresApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        liveTablePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveTablePresenter.detachScreen();
    }

    @Override
    public void showLiveTable() {
        liveTablePresenter.refreshTable();
    }
}
