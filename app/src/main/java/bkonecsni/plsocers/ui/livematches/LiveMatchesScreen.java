package bkonecsni.plsocers.ui.livematches;

import bkonecsni.plsocers.model.db.FavouriteMatch;

public interface LiveMatchesScreen {

    void showLiveMatches();

    void addMatchToFavourites(FavouriteMatch favouriteMatch);
}
