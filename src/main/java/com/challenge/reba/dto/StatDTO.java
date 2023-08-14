package com.challenge.reba.dto;

import lombok.Data;

@Data
public class StatDTO {

    private String country;

    private String percentage;

    public StatDTO(){

    }

    public StatDTO(String percentage, String country) {
        this.percentage = percentage;
        this.country = country;
    }
}
