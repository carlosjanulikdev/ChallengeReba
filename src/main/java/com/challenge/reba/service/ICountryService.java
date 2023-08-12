package com.challenge.reba.service;

import com.challenge.reba.model.Country;

import java.util.List;

public interface ICountryService {

    Country findById(Long id);
    List<Country> findAll();
}
