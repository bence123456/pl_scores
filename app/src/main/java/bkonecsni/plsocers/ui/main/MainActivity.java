package bkonecsni.plsocers.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.ui.livematches.LiveMatchesActivity;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class MainActivity extends DrawerActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_main, R.string.welcome);

        PlScoresApplication.injector.inject(this);

        Button btnShowLiveMatches = (Button) findViewById(R.id.btnShowLiveMatches);
        btnShowLiveMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.startLiveMatchesActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showLiveMatches() {
        Intent intent = new Intent(MainActivity.this, LiveMatchesActivity.class);
        startActivity(intent);
    }
}
