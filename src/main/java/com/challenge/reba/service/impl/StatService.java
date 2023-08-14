package com.challenge.reba.service.impl;

import com.challenge.reba.dto.StatDTO;
import com.challenge.reba.repository.StatRepository;
import com.challenge.reba.resultset.StatResultSet;
import com.challenge.reba.service.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService implements IStatService {

    @Autowired
    private StatRepository statRepository;

    public List<StatDTO> findPercentagesByCountry(){
        List<StatResultSet> listResultSet = statRepository.findPersonsCountByCountry();

        Double personsTotal = listResultSet.stream().mapToDouble( p -> p.getCount()).sum();
        //Converting from List<StatResultSet> to List<StatDTO>
        List<StatDTO> list = listResultSet.stream()
                                .map( st -> new StatDTO(
                                        (Double.valueOf(st.getCount()/personsTotal*100)).toString(),
                                                        st.getCountry())).toList();

        return list;
    }
}
