package bkonecsni.plsocers.db;

import android.database.Cursor;

import java.sql.SQLException;

public class FavouriteMatchesDbLoader {

    public void open() throws SQLException {
    }

    public void close(){
    }

    public long createFavouriteMatch(DbConstants.FavouriteMatch favouriteMatch){
        return 0;
    }

    public boolean deleteFavouriteMatch(long rowId){
        return true;
    }

    public Cursor fetchAll(){
        return null;
    }
}
