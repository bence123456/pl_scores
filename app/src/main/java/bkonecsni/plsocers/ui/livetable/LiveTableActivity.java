package bkonecsni.plsocers.ui.livetable;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.api.Team;
import bkonecsni.plsocers.ui.menu.DrawerActivity;

public class LiveTableActivity extends DrawerActivity implements LiveTableScreen {

    @Inject
    LiveTablePresenter liveTablePresenter;

    private RecyclerView recyclerViewTeams;
    private ArrayList<Team> teamList;
    private TableAdapter tableAdapter;
    private SwipeRefreshLayout swipeRefreshLayoutTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addView(R.layout.activity_livetable, R.string.standing);

        PlScoresApplication.injector.inject(this);

        recyclerViewTeams = (RecyclerView) findViewById(R.id.recyclerViewTeams);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTeams.setLayoutManager(llm);

        teamList = new ArrayList<>();
        tableAdapter = new TableAdapter(getApplicationContext(), teamList);
        recyclerViewTeams.setAdapter(tableAdapter);

        swipeRefreshLayoutTable = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutTable);
        swipeRefreshLayoutTable.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //                liveTablePresenter.refreshTable();
                showLiveTable(Arrays.asList(
                        createTeam("Manchester City", 36, 30, 4, 2, 94),
                        createTeam("Manchester United", 36, 24, 5, 7, 77),
                        createTeam("LiverPool FC", 36, 20, 12, 5, 72),
                        createTeam("Totttenham Hotspur FC", 36, 21, 8, 7, 71),
                        createTeam("Chelsea FC", 36, 21, 6, 9, 69),
                        createTeam("Arsenal", 36, 18, 6, 12, 60),
                        createTeam("West Bromwich Albion FC", 36, 14, 12, 11, 54)
                ));
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
    public void onResume() {
        super.onResume();
//        liveTablePresenter.refreshTable();
        showLiveTable(Arrays.asList(
                createTeam("Manchester City", 36, 30, 4, 2, 94),
                createTeam("Manchester United", 36, 24, 5, 7, 77),
                createTeam("LiverPool FC", 36, 20, 12, 5, 72),
                createTeam("Totttenham Hotspur FC", 36, 21, 8, 7, 71),
                createTeam("Csicska FC", 36, 21, 6, 9, 69),
                createTeam("Arsenal FC", 36, 18, 6, 12, 60),
                createTeam("West Bromwich Albion FC", 36, 14, 12, 11, 54)
        ));
    }


    @Override
    public void showLiveTable(List<Team> teams) {
        if (swipeRefreshLayoutTable != null) {
            swipeRefreshLayoutTable.setRefreshing(false);
        }

        teamList.clear();
        teamList.addAll(teams);
        tableAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        if (swipeRefreshLayoutTable != null) {
            swipeRefreshLayoutTable.setRefreshing(false);
        }
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

    private Team createTeam(String teamName, Integer played, Integer wins, Integer draws, Integer losses, Integer points) {
        Team team = new Team();

        team.setTeamName(teamName);
        team.setPlayedGames(played);
        team.setWins(wins);
        team.setDraws(draws);
        team.setLosses(losses);
        team.setGoals(86);
        team.setGoalsAgainst(61);
        team.setPoints(points);

        return team;
    }
}
