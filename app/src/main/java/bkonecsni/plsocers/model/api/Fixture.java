package bkonecsni.plsocers.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class Fixture   {

    @SerializedName("date")
    private String date = null;

    @SerializedName("status")
    private String status = null;

    @SerializedName("matchday")
    private Integer matchday = null;

    @SerializedName("homeTeamName")
    private String homeTeamName = null;

    @SerializedName("awayTeamName")
    private String awayTeamName = null;

    @SerializedName("result")
    private Result result = null;

    @ApiModelProperty(required = true, value = "")
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }


    @ApiModelProperty(value = "")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @ApiModelProperty(value = "")
    public Integer getMatchday() {
        return matchday;
    }
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    @ApiModelProperty(required = true, value = "")
    public String getHomeTeamName() {
        return homeTeamName;
    }
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    @ApiModelProperty(required = true, value = "")
    public String getAwayTeamName() {
        return awayTeamName;
    }
    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    @ApiModelProperty(value = "")
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }


        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fixture fixture = (Fixture) o;
        return Objects.equals(date, fixture.date) &&
                Objects.equals(status, fixture.status) &&
                Objects.equals(matchday, fixture.matchday) &&
                Objects.equals(homeTeamName, fixture.homeTeamName) &&
                Objects.equals(awayTeamName, fixture.awayTeamName) &&
                Objects.equals(result, fixture.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, status, matchday, homeTeamName, awayTeamName, result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Fixture {\n");

        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    matchday: ").append(toIndentedString(matchday)).append("\n");
        sb.append("    homeTeamName: ").append(toIndentedString(homeTeamName)).append("\n");
        sb.append("    awayTeamName: ").append(toIndentedString(awayTeamName)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
