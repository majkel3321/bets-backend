
package com.lewicki.betsbackend.domain.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Api {

    @SerializedName("results")
    @Expose
    public Integer results;
    @SerializedName("players")
    @Expose
    public List<Player> players = null;

}
