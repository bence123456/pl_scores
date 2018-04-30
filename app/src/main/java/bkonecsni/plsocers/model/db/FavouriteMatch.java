package bkonecsni.plsocers.model.db;

import com.orm.SugarRecord;

public class FavouriteMatch extends SugarRecord<FavouriteMatch> {

    private String date;

    private String status;

    private Integer matchday;

    private String homeTeamName;

    private int homeTeamGoals;

    private String awayTeamName;

    private int awayTeamGoals;

    public FavouriteMatch() {
    }

    public FavouriteMatch(String date, String status, Integer matchday, String homeTeamName, int homeTeamGoals, String awayTeamName, int awayTeamGoals) {
        this.date = date;
        this.status = status;
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamName = awayTeamName;
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }
}
