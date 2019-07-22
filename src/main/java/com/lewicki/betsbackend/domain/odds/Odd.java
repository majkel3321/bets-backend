
package com.lewicki.betsbackend.domain.odds;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
