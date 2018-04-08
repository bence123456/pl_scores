package bkonecsni.plsocers.ui.livematches;

import bkonecsni.plsocers.db.DbConstants;

public interface LiveMatchesScreen {

    void showLiveMatches();

    void addMatchToFavourites(DbConstants.FavouriteMatch favouriteMatch);
}
