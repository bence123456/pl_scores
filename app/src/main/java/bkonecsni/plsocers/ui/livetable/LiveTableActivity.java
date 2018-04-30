package bkonecsni.plsocers.ui.livetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;

public class LiveTableActivity extends AppCompatActivity implements LiveTableScreen {

    @Inject
    LiveTablePresenter liveTablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livetable);

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
