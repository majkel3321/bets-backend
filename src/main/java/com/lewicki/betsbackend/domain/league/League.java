
package com.lewicki.betsbackend.domain.league;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class League {

    @SerializedName("api")
    @Expose
    public Api api;

}
