
package com.lewicki.betsbackend.domain.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Player {

    @SerializedName("player_id")
    @Expose
    public Long playerId;
    @SerializedName("player_name")
    @Expose
    public String playerName;
    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("number")
    @Expose
    public Object number;
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("age")
    @Expose
    public Integer age;
    @SerializedName("birth_date")
    @Expose
    public String birthDate;
    @SerializedName("birth_place")
    @Expose
    public String birthPlace;
    @SerializedName("birth_country")
    @Expose
    public String birthCountry;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("weight")
    @Expose
    public String weight;

}
