package bkonecsni.plsocers.ui.livetable;

import java.util.List;

import bkonecsni.plsocers.model.api.Team;
import bkonecsni.plsocers.ui.common.CommonScreen;

public interface LiveTableScreen extends CommonScreen {

    void showLiveTable(List<Team> standing);
}
