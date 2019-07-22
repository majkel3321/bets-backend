package com.lewicki.betsbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    @Id
    @GeneratedValue
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private double v1;
    private double x;
    private double v2;

    public MatchDto(String homeTeam, String awayTeam, double v1, double x, double v2) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.v1 = v1;
        this.x = x;
        this.v2 = v2;
    }
}
