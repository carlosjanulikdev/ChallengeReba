package com.challenge.reba.controller;

import com.challenge.reba.dto.StatDTO;
import com.challenge.reba.service.IStatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stats")
public class StatController {
    Logger logger = LoggerFactory.getLogger(StatController.class);

    @Autowired
    private IStatService statService;

    /**
     *
     * @return a list of countries and its percentage
     */
    @GetMapping(value = "/")
    public List<StatDTO> findPercentagesByCountry(){
        return statService.findPercentagesByCountry();
    }


}
