package bkonecsni.plsocers.ui.favouritematches;

import java.util.List;

import bkonecsni.plsocers.model.db.FavouriteMatch;

public interface FavouriteMatchesScreen {

    void showFavouriteMatches(List<FavouriteMatch> favouriteMatchList);

    void removeFromFavourites(long rowId);
}
