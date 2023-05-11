package com.example.command.services;

import com.example.command.entity.Severity;
import com.example.command.repository.AlarmSeverityQueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlarmSeverityServices {

    @Autowired
    private AlarmSeverityQueryRepository alarmSeverityQueryRepository;

    public Iterable<Severity> getAllSeverity() {
        return alarmSeverityQueryRepository.findAll();
    }
}
