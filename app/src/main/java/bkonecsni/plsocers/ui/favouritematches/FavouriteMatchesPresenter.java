package bkonecsni.plsocers.ui.favouritematches;

import javax.inject.Inject;

import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;

public class FavouriteMatchesPresenter {

    @Inject
    FavouriteMatchesInteractor favouriteMatchesInteractor;

    public void listFavouriteMatches() {
        favouriteMatchesInteractor.getFavouriteMatches();
    }

    public void removeFavouriteMatch(long rowId) {
        favouriteMatchesInteractor.deleteFavouriteMatch(rowId);
    }

}
