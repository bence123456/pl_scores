package bkonecsni.plsocers.ui.livetable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.api.Team;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class LiveTableActivity extends DrawerActivity implements LiveTableScreen {

    @Inject
    LiveTablePresenter liveTablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_livetable, R.string.standing);

        PlScoresApplication.injector.inject(this);

        Button refreshMatches = (Button) findViewById(R.id.btnRefreshTable);
        refreshMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveTablePresenter.refreshTable();
            }
        });
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
    public void showLiveTable(List<Team> standing) {
//        liveTablePresenter.refreshTable();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
    }
}
