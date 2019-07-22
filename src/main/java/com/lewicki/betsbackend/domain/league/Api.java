
package com.lewicki.betsbackend.domain.league;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class Api {

    @SerializedName("results")
    @Expose
    public Integer results;
    @SerializedName("teams")
    @Expose
    public List<TeamInfo> teams = null;

}
