package com.example.command.repository;

import com.example.command.entity.Severity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlarmSeverityQueryRepository extends CrudRepository<Severity, Integer> {

    /**
     *
     * @param severity
     * @return
     */
    @Query(value = "select id from alarm.tbl_severity where severity = :severity", nativeQuery = true)
    Optional<Integer> getIdByName(String severity);
}
