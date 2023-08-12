package com.challenge.reba.controller;

import com.challenge.reba.model.Country;
import com.challenge.reba.service.ICountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private ICountryService countryService;

    /**
     *
     * @param id
     * @return a country by id
     */
    @GetMapping(value = "/get/{id}")
    public Country findById(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return countryService.findById(id);
    }

    /**
     *
     * @return a JSON with all countries
     */
    @GetMapping(value = "/findAll")
    public @ResponseBody Iterable<Country> findAll() {
        return countryService.findAll();
    }
}
