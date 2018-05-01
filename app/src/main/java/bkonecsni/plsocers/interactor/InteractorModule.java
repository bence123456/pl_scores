package bkonecsni.plsocers.interactor;

import bkonecsni.plsocers.interactor.favouritematches.FavouriteMatchesInteractor;
import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    public static final long COMPETITION_ID = 445L;
    public static final String FILTER_FOR_NEXT_7_DAYS = "n7";

    @Provides
    public LiveMatchesInteractor provideLiveMatchesInteractor() {
        return new LiveMatchesInteractor();
    }

    @Provides
    public LiveTableInteractor provideLiveTableInteractor() {
        return new LiveTableInteractor();
    }

    @Provides
    public FavouriteMatchesInteractor provideFavouriteMatchesInteractor() {
        return new FavouriteMatchesInteractor();
    }
}
