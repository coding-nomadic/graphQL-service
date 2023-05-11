package com.example.command.controller;

import com.example.command.entity.Alarm;
import com.example.command.entity.Severity;
import com.example.command.services.AlarmCommandQueryService;
import com.example.command.services.AlarmSeverityServices;
import com.example.command.utls.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AlarmQueryController {

    @Autowired
    private AlarmSeverityServices alarmSeverityServices;

    @Autowired
    private AlarmCommandQueryService alarmCommandQueryService;

    /**
     * 
     * @return
     * @throws IOException creates Alarm in DB.
     */
    @QueryMapping("getAllSeverity")
    public Iterable<Severity> getAllSeverity() throws IOException {
        final Iterable<Severity> listOfSeverity = alarmSeverityServices.getAllSeverity();
        log.info("Fetching all Alarm Severity {}", JsonUtils.toString(listOfSeverity));
        return listOfSeverity;
    }

    @QueryMapping("getAlarm")
    public Alarm getAlarm(@Argument(name = "alarmId") Integer id) throws IOException {
        log.info("Fetching Alarm Command By ID {}", id);
        final Alarm alarmResponse = alarmCommandQueryService.fetchAlarmCommandById(id);
        log.info("Alarm fetched successfully for ID {}", JsonUtils.toString(alarmResponse));
        return alarmResponse;
    }
}
