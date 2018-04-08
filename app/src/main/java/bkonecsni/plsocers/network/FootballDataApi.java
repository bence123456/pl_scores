package bkonecsni.plsocers.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FootballDataApi {

    @GET("/competitions/445/fixtures")
    Call<Object> listFixtures(@Query("matchday") int matchday);
}
