package bkonecsni.plsocers.interactor.favouritematches;

import com.google.common.collect.Lists;

import java.util.List;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.model.db.FavouriteMatch;

public class FavouriteMatchesInteractor {

    public FavouriteMatchesInteractor() {
        PlScoresApplication.injector.inject(this);
    }

    public List<FavouriteMatch> getFavouriteMatches() {
        return  Lists.newArrayList( FavouriteMatch.findAll(FavouriteMatch.class));
    }

    public void createFavouriteMatch(FavouriteMatch favouriteMatch) {
        favouriteMatch.save();
    }

    public void deleteFavouriteMatch(long id) {
        FavouriteMatch favouriteMatch = FavouriteMatch.findById(FavouriteMatch.class, id);
        favouriteMatch.delete();
    }

}
