package com.challenge.reba.service;

import com.challenge.reba.dto.StatDTO;

import java.util.List;

public interface IStatService {

    List<StatDTO> findPercentagesByCountry();
}
