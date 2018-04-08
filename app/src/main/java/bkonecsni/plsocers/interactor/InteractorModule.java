package bkonecsni.plsocers.interactor;

import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public LiveMatchesInteractor provideLiveMatchesInteractor() {
        return new LiveMatchesInteractor();
    }

    @Provides
    public LiveTableInteractor provideLiveTableInteractor() {
        return new LiveTableInteractor();
    }
}
