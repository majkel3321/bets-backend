
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
public class Odd {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

}
