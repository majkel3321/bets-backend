
package com.lewicki.betsbackend.domain.odds;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Datum {

    @SerializedName("sport_key")
    @Expose
    public String sportKey;
    @SerializedName("sport_nice")
    @Expose
    public String sportNice;
    @SerializedName("teams")
    @Expose
    public List<String> teams = null;
    @SerializedName("commence_time")
    @Expose
    public Integer commenceTime;
    @SerializedName("home_team")
    @Expose
    public String homeTeam;
    @SerializedName("sites")
    @Expose
    public List<Site> sites = null;
    @SerializedName("sites_count")
    @Expose
    public Integer sitesCount;

}
