package bkonecsni.plsocers.ui.livetable;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class LiveTableActivity extends AppCompatActivity implements LiveTableScreen {

    @Inject
    LiveTablePresenter liveTablePresenter;

    @Override
    public void showLiveTable() {
        liveTablePresenter.refreshTable();
    }
}
