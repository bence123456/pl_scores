package bkonecsni.plsocers.interactor.favouritematches;

import javax.inject.Inject;

import bkonecsni.plsocers.db.DbConstants;
import bkonecsni.plsocers.db.FavouriteMatchesDbLoader;

public class FavouriteMatchesInteractor {

    @Inject
    FavouriteMatchesDbLoader favouriteMatchesDbLoader;

    public void getFavouriteMatches() {
        favouriteMatchesDbLoader.fetchAll();
    }

    public void createFavouriteMatch(DbConstants.FavouriteMatch favouriteMatch) {
        favouriteMatchesDbLoader.createFavouriteMatch(favouriteMatch);
    }

    public void deleteFavouriteMatch(long rowId) {
        favouriteMatchesDbLoader.deleteFavouriteMatch(rowId);
    }

}
