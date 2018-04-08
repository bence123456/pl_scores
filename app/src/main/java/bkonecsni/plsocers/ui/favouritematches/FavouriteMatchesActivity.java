package bkonecsni.plsocers.ui.favouritematches;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class FavouriteMatchesActivity extends AppCompatActivity implements FavouriteMatchesScreen{

    @Inject
    FavouriteMatchesPresenter favouriteMatchesPresenter;

    @Override
    public void showFavouriteMatches() {
        favouriteMatchesPresenter.listFavouriteMatches();
    }

    @Override
    public void removeFromFavourites(long rowId) {
        favouriteMatchesPresenter.removeFavouriteMatch(rowId);
    }
}
