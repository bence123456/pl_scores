package bkonecsni.plsocers.db;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    public FavouriteMatchesDbLoader provideFavouriteMatchesDbLoader() {
        return new FavouriteMatchesDbLoader();
    }
}
