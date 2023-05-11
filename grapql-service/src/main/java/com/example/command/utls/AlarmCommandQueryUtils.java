package com.example.command.utls;

import com.example.command.dtos.AlarmCommandResponse;
import com.example.command.entity.Alarm;
import com.example.command.entity.Severity;
import com.example.command.entity.ProductType;
import com.example.command.entity.Proposition;

import java.util.Optional;

public class AlarmCommandQueryUtils {
    private AlarmCommandQueryUtils() {

    }

    /**
     * @param alarmCommand
     * @param productType
     * @param alarmSeverity
     * @return
     */
    public static AlarmCommandResponse convertGetResponse(Optional<Alarm> alarmCommand,
                                    Optional<ProductType> productType, Optional<Severity> alarmSeverity,
                                    Optional<Proposition> proposition) {
        AlarmCommandResponse alarmCommandResponse = new AlarmCommandResponse();
        alarmCommandResponse.setId(alarmCommand.get().getId());
        alarmCommandResponse.setName(alarmCommand.get().getName());
        alarmCommandResponse.setReadonly(alarmCommand.get().isReadOnly());
        productType.ifPresent(p -> {
            alarmCommandResponse.setProductType(p.getName());
        });
        alarmSeverity.ifPresent(s -> {
            alarmCommandResponse.setSeverity(s.getSeverity());
        });
        proposition.ifPresent(p -> {
            alarmCommandResponse.setBusiness(p.getProposition());
        });
        return alarmCommandResponse;
    }
}
