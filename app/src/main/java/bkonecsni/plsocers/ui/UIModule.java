package bkonecsni.plsocers.ui;

import android.content.Context;

import javax.inject.Singleton;

import bkonecsni.plsocers.ui.favouritematches.FavouriteMatchesPresenter;
import bkonecsni.plsocers.ui.livematches.LiveMatchesPresenter;
import bkonecsni.plsocers.ui.livetable.LiveTablePresenter;
import bkonecsni.plsocers.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LiveMatchesPresenter provideLiveMatchesPresenter() {
        return new LiveMatchesPresenter();
    }

    @Provides
    @Singleton
    public LiveTablePresenter provideLiveTablePresenter() {
        return new LiveTablePresenter();
    }

    @Provides
    @Singleton
    public FavouriteMatchesPresenter provideFavouriteMatchesPresenter() {
        return new FavouriteMatchesPresenter();
    }

}
