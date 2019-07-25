
package com.lewicki.betsbackend.domain.league;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TeamInfo {

    @Id
    @SerializedName("team_id")
    @Expose
    public Long team_id;
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("founded")
    @Expose
    public int founded;
    @SerializedName("venue_name")
    @Expose
    public String venue_name;
    @SerializedName("venue_surface")
    @Expose
    public String venue_surface;
    @SerializedName("venue_address")
    @Expose
    public String venue_address;
    @SerializedName("venue_city")
    @Expose
    public String venue_city;
    @SerializedName("venue_capacity")
    @Expose
    public int venue_capacity;

    public TeamInfo(String name) {
        this.name = name;
    }
}
