package bkonecsni.plsocers.ui.favouritematches;

import java.util.ArrayList;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.Presenter;

public class FavouriteMatchesPresenter extends Presenter<FavouriteMatchesScreen> {

    @Inject
    FavouriteMatchesInteractor favouriteMatchesInteractor;

    @Override
    public void attachScreen(FavouriteMatchesScreen screen) {
        super.attachScreen(screen);
        PlScoresApplication.injector.inject(this);
    }

    public void showFavouriteMatches() {
        screen.showFavouriteMatches(getFavouriteMatches());
    }

    public ArrayList<FavouriteMatch> getFavouriteMatches() {
        return (ArrayList<FavouriteMatch>) favouriteMatchesInteractor.getFavouriteMatches();
    }

    public void removeFavouriteMatch(long id) {
        favouriteMatchesInteractor.deleteFavouriteMatch(id);
    }

}
