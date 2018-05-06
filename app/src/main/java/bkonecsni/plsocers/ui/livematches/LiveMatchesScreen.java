package bkonecsni.plsocers.ui.livematches;

import java.util.List;

import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.common.CommonScreen;

public interface LiveMatchesScreen extends CommonScreen {

    void showLiveMatches(List<Fixture> fixtures);

    void addMatchToFavourites(FavouriteMatch favouriteMatch);
}
