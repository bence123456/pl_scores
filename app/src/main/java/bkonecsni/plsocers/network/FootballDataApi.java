package bkonecsni.plsocers.network;

import bkonecsni.plsocers.model.api.Fixtures;
import bkonecsni.plsocers.model.api.Table;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FootballDataApi {

    /**
     * Returns list of matches
     * Returns list of matches in the PL in the next 7 days
     * @param compId ID of the competition
     * @param timeFrame Filter for time frame
     * @return Call<Fixtures>
     */
    @GET("competitions/{compId}/fixtures")
    Call<Fixtures> listFixtures(@Path("compId") Long compId, @Query("timeFrame") String timeFrame);
    /**
     * Returns the league table
     * Returns the league table in the PL on the current matchday
     * @param compId ID of the competition
     * @return Call<Table>
     */
    @GET("competitions/{compId}/leagueTable")
    Call<Table> getLeagueTable(@Path("compId") Long compId);

}
