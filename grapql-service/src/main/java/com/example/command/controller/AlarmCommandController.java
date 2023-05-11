package com.example.command.controller;

import com.example.command.dtos.AlarmCommandRequest;
import com.example.command.dtos.AlarmCommandUpdateRequest;
import com.example.command.entity.Alarm;
import com.example.command.services.AlarmCommandService;
import com.example.command.utls.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AlarmCommandController {

    @Autowired
    private AlarmCommandService alarmService;

    @MutationMapping("createAlarm")
    public Alarm createAlarm(@Argument(name = "alarm") AlarmCommandRequest alarmCommandRequest) throws IOException {
        log.info("Entered the Alarm Command Request {}", JsonUtils.toString(alarmCommandRequest));
        final Alarm alarmResponse = alarmService.saveCommand(alarmCommandRequest);
        log.info("Alarm created successfully {}", JsonUtils.toString(alarmResponse));
        return alarmResponse;
    }

    @MutationMapping("updateAlarm")
    public Alarm updateAlarm(@Argument(name = "alarm") AlarmCommandUpdateRequest alarmRequest,
                                    @Argument(name = "id") Integer id) throws IOException {
        log.info("Entered the Alarm Command Update Request {}", JsonUtils.toString(alarmRequest));
        final Alarm alarmResponse = alarmService.updateCommand(alarmRequest, id);
        log.info("Alarm updated successfully {}", JsonUtils.toString(alarmResponse));
        return alarmResponse;
    }

    @MutationMapping("deleteAlarm")
    public Boolean deleteAlarm(@Argument(name = "alarmId") Integer id) {
        log.info("Entered the Alarm Command Delete Request with ID {}", id);
        Boolean response = alarmService.deleteCommand(id);
        log.info("Alarm deleted successfully for ID {}", response);
        return response;
    }
}
