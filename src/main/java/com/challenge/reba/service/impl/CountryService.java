package com.challenge.reba.service.impl;

import com.challenge.reba.model.Country;
import com.challenge.reba.repository.CountryRepository;
import com.challenge.reba.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findById(Long id){
        return countryRepository.findById(id).get();
    }
    public List<Country> findAll(){
        return (List<Country>) countryRepository.findAll();
    }
}
