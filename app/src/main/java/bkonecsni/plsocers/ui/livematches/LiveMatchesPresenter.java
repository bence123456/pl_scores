package bkonecsni.plsocers.ui.livematches;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.di.Network;
import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.interactor.livematches.GetLiveMatchesEvent;
import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.model.db.FavouriteMatch;
import bkonecsni.plsocers.ui.common.CommonPresenter;

public class LiveMatchesPresenter extends CommonPresenter<LiveMatchesScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    LiveMatchesInteractor liveMatchesInteractor;

    @Inject
    FavouriteMatchesInteractor favouriteMatchesInteractor;

    @Override
    public void attachScreen(LiveMatchesScreen screen) {
        super.attachScreen(screen);
        PlScoresApplication.injector.inject(this);
    }

    public void refreshMatches() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                liveMatchesInteractor.getLiveMatches();
            }
        });
    }

    public void addFavouriteMatch(FavouriteMatch favouriteMatch) {
        favouriteMatchesInteractor.createFavouriteMatch(favouriteMatch);
    }

    public List<FavouriteMatch> getFavouriteMatches() {
        return favouriteMatchesInteractor.getFavouriteMatches();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetLiveMatchesEvent event) {
        if (event.getThrowable() != null) {
            handleNetworkError(event);
        } else {
            if (screen != null) {
                screen.showLiveMatches(event.getItems());
            }
        }
    }
}
