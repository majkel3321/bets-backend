
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
public class Odds {

    @SerializedName("h2h")
    @Expose
    public List<Double> h2h = null;
    @SerializedName("h2h_lay")
    @Expose
    public List<Double> h2hLay = null;

}
