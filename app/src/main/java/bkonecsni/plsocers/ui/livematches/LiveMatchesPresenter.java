package bkonecsni.plsocers.ui.livematches;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.Presenter;

public class LiveMatchesPresenter extends Presenter<LiveMatchesScreen> {

    @Inject
    LiveMatchesInteractor liveMatchesInteractor;

    @Inject
    FavouriteMatchesInteractor favouriteMatchesInteractor;

    @Override
    public void attachScreen(LiveMatchesScreen screen) {
        super.attachScreen(screen);
        PlScoresApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshMatches() {
       liveMatchesInteractor.getLiveMatches();
    }

    public void addFavouriteMatch(FavouriteMatch favouriteMatch) {
        favouriteMatchesInteractor.createFavouriteMatch(favouriteMatch);
    }
}
