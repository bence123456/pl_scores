package bkonecsni.plsocers.interactor;

import bkonecsni.plsocers.interactor.livematches.LiveMatchesInteractor;
import dagger.Provides;

public class InteractorModule {

    @Provides
    public LiveMatchesInteractor provideLiveMatchesInteractor() {
        return new LiveMatchesInteractor();
    }
}
