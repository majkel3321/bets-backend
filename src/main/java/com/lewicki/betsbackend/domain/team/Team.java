
package com.lewicki.betsbackend.domain.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Team {

    @SerializedName("api")
    @Expose
    public Api api;

}
