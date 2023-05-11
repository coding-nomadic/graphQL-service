package com.example.command.repository;

import com.example.command.entity.Proposition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Integer> {

    /**
     *
     * @param proposition
     * @return
     */
    @Query(value = "select id from alarm.tbl_proposition where proposition = :proposition", nativeQuery = true)
    Optional<Integer> getIdByName(String proposition);
}
