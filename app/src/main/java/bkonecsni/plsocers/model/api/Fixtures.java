package bkonecsni.plsocers.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

@ApiModel(description = "")
public class Fixtures   {

    @SerializedName("count")
    private Integer count = null;

    @SerializedName("fixtures")
    private List<Fixture> fixtures = new ArrayList<Fixture>();

    @ApiModelProperty(value = "")
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    @ApiModelProperty(value = "")
    public List<Fixture> getFixtures() {
        return fixtures;
    }
    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fixtures fixtures = (Fixtures) o;
        return Objects.equals(count, fixtures.count) &&
                Objects.equals(fixtures, fixtures.fixtures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, fixtures);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Fixtures {\n");

        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    fixtures: ").append(toIndentedString(fixtures)).append("\n");
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
