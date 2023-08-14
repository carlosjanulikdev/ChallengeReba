package com.challenge.reba.repository;

import com.challenge.reba.model.Person;
import com.challenge.reba.resultset.StatResultSet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepository extends CrudRepository<Person, Long> {

    @Query("SELECT new com.challenge.reba.resultset.StatResultSet(count(p.country.id), p.country.name) FROM Person p group by p.country.id")
    List<StatResultSet> findPersonsCountByCountry();
}
