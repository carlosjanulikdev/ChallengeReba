package com.challenge.reba.resultset;

import lombok.Data;

@Data
public class StatResultSet {
    private String country;

    private Long count;

    public StatResultSet(){

    }

    public StatResultSet(Long count, String country) {
        this.count = count;
        this.country = country;
    }
}
