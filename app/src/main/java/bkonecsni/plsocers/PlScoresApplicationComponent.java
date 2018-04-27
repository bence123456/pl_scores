package bkonecsni.plsocers;

import javax.inject.Singleton;

import bkonecsni.plsocers.db.DbModule;
import bkonecsni.plsocers.interactor.InteractorModule;
import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import bkonecsni.plsocers.network.NetworkModule;
import bkonecsni.plsocers.ui.UIModule;
import bkonecsni.plsocers.ui.favouritematches.FavouriteMatchesActivity;
import bkonecsni.plsocers.ui.favouritematches.FavouriteMatchesPresenter;
import bkonecsni.plsocers.ui.livematches.LiveMatchesActivity;
import bkonecsni.plsocers.ui.livematches.LiveMatchesPresenter;
import bkonecsni.plsocers.ui.livetable.LiveTableActivity;
import bkonecsni.plsocers.ui.livetable.LiveTablePresenter;
import bkonecsni.plsocers.ui.main.MainActivity;
import bkonecsni.plsocers.ui.main.MainPresenter;
import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class, DbModule.class})
public interface PlScoresApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);

    void inject(LiveMatchesActivity liveMatchesActivity);
    void inject(LiveMatchesInteractor liveMatchesInteractor);
    void inject(LiveMatchesPresenter liveMatchesPresenter);

    void inject(LiveTableActivity liveTableActivity);
    void inject(LiveTableInteractor liveTableInteractor);
    void inject(LiveTablePresenter liveTablePresenter);

    void inject(FavouriteMatchesActivity favouriteMatchesActivity);
    void inject(FavouriteMatchesInteractor favouriteMatchesInteractor);
    void inject(FavouriteMatchesPresenter favouriteMatchesPresenter);
}
