package com.example.command.repository;

import com.example.command.entity.Alarm;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmCommandRepository extends CrudRepository<Alarm, Integer> {


}
