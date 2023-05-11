package com.example.command.services;

import com.example.command.constants.AlarmCommandConstants;
import com.example.command.entity.Alarm;
import com.example.command.repository.AlarmCommandQueryRepository;
import com.example.command.utls.AlarmCommandCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlarmCommandQueryService {

    @Autowired
    private AlarmCommandQueryRepository alarmQueryRepository;

    public Alarm fetchAlarmCommandById(Integer id) {
        final Optional<Alarm> alarmCommand = alarmQueryRepository.findById(id);
        AlarmCommandCheckUtils.isAlarmExists(alarmCommand, AlarmCommandConstants.NOT_FOUND);
        return alarmCommand.get();
    }
}
