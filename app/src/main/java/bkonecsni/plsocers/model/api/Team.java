package bkonecsni.plsocers.model.api;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Team   {

    @SerializedName("position")
    private Integer position = null;

    @SerializedName("teamName")
    private String teamName = null;

    @SerializedName("crestURI")
    private String crestURI = null;

    @SerializedName("playedGames")
    private Integer playedGames = null;

    @SerializedName("wins")
    private Integer wins = null;

    @SerializedName("draws")
    private Integer draws = null;

    @SerializedName("losses")
    private Integer losses = null;

    @SerializedName("points")
    private Integer points = null;

    @SerializedName("goals")
    private Integer goals = null;

    @SerializedName("goalsAgainst")
    private Integer goalsAgainst = null;

    @SerializedName("goalDifference")
    private Integer goalDifference = null;

    @ApiModelProperty(required = true, value = "")
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    @ApiModelProperty(value = "")
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @ApiModelProperty(value = "")
    public String getCrestURI() {
        return crestURI;
    }
    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getPlayedGames() {
        return playedGames;
    }
    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getWins() {
        return wins;
    }
    public void setWins(Integer wins) {
        this.wins = wins;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getDraws() {
        return draws;
    }
    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getLosses() {
        return losses;
    }
    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getGoals() {
        return goals;
    }
    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }
    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    @ApiModelProperty(required = true, value = "")
    public Integer getGoalDifference() {
        return goalDifference;
    }
    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(position, team.position) &&
                Objects.equals(teamName, team.teamName) &&
                Objects.equals(crestURI, team.crestURI) &&
                Objects.equals(playedGames, team.playedGames) &&
                Objects.equals(wins, team.wins) &&
                Objects.equals(draws, team.draws) &&
                Objects.equals(losses, team.losses) &&
                Objects.equals(points, team.points) &&
                Objects.equals(goals, team.goals) &&
                Objects.equals(goalsAgainst, team.goalsAgainst) &&
                Objects.equals(goalDifference, team.goalDifference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, teamName, crestURI, playedGames, wins, draws, losses, points, goals, goalsAgainst, goalDifference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Team {\n");

        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    teamName: ").append(toIndentedString(teamName)).append("\n");
        sb.append("    crestURI: ").append(toIndentedString(crestURI)).append("\n");
        sb.append("    playedGames: ").append(toIndentedString(playedGames)).append("\n");
        sb.append("    wins: ").append(toIndentedString(wins)).append("\n");
        sb.append("    draws: ").append(toIndentedString(draws)).append("\n");
        sb.append("    losses: ").append(toIndentedString(losses)).append("\n");
        sb.append("    points: ").append(toIndentedString(points)).append("\n");
        sb.append("    goals: ").append(toIndentedString(goals)).append("\n");
        sb.append("    goalsAgainst: ").append(toIndentedString(goalsAgainst)).append("\n");
        sb.append("    goalDifference: ").append(toIndentedString(goalDifference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
