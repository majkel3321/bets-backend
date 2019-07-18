
package com.lewicki.betsbackend.domain.odds;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Site {

    @SerializedName("site_key")
    @Expose
    public String siteKey;
    @SerializedName("site_nice")
    @Expose
    public String siteNice;
    @SerializedName("last_update")
    @Expose
    public Integer lastUpdate;
    @SerializedName("odds")
    @Expose
    public Odds odds;

}
