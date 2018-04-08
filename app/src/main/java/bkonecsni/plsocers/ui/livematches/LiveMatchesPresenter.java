package bkonecsni.plsocers.ui.livematches;

import javax.inject.Inject;

import bkonecsni.plsocers.db.DbConstants;
import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.ui.Presenter;

public class LiveMatchesPresenter extends Presenter<LiveMatchesScreen> {

    @Inject
    LiveMatchesInteractor liveMatchesInteractor;

    @Inject
    FavouriteMatchesInteractor favouriteMatchesInteractor;

    public void refreshMatches() {
       liveMatchesInteractor.getLiveMatches();
    }

    public void addFavouriteMatch(DbConstants.FavouriteMatch favouriteMatch) {
        favouriteMatchesInteractor.createFavouriteMatch(favouriteMatch);
    }
}
