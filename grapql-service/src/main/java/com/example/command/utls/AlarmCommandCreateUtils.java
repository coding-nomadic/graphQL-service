package com.example.command.utls;

import com.example.command.constants.AlarmCommandConstants;
import com.example.command.dtos.AlarmCommandRequest;
import com.example.command.dtos.AlarmCommandResponse;
import com.example.command.dtos.AlarmCommandUpdateRequest;
import com.example.command.entity.Alarm;

import java.util.Optional;

/**
 * helps in transforming from one to another Object.
 */
public class AlarmCommandCreateUtils {
    private AlarmCommandCreateUtils() {

    }

    /**
     * @param alarmCommand
     * @param alarmCommandRequest
     * @return
     */
    public static AlarmCommandResponse alarmCommandResponse(Alarm alarmCommand,
                                    AlarmCommandRequest alarmCommandRequest) {
        AlarmCommandResponse alarmCommandResponse = new AlarmCommandResponse();
        alarmCommandResponse.setBusiness(alarmCommandRequest.getBusiness());
        alarmCommandResponse.setName(alarmCommandRequest.getName());
        alarmCommandResponse.setProductType(alarmCommandRequest.getProductType());
        alarmCommandResponse.setReadonly(alarmCommandRequest.isReadonly());
        alarmCommandResponse.setSeverity(alarmCommandRequest.getSeverity());
        alarmCommandResponse.setId(alarmCommand.getId());
        return alarmCommandResponse;
    }

    /**
     * @param alarmCommandRequest
     * @param productTypeId
     * @param severityId
     * @return
     */
    public static Alarm alarmCommand(AlarmCommandRequest alarmCommandRequest, Integer productTypeId,
                                    Integer severityId) {
        Alarm alarmCommand = new Alarm();
        alarmCommand.setProductTypeId(productTypeId);
        alarmCommand.setSeverityId(severityId);
        alarmCommand.setName(alarmCommandRequest.getName());
        alarmCommand.setReadOnly(alarmCommandRequest.isReadonly());
        return alarmCommand;
    }

    /**
     * @param update
     * @param alarmCommandUpdateRequest
     * @return
     */
    public static AlarmCommandResponse convertUpdateResponse(Alarm update,
                                    AlarmCommandUpdateRequest alarmCommandUpdateRequest) {
        AlarmCommandResponse alarmCommandResponse = new AlarmCommandResponse();
        alarmCommandResponse.setId(update.getId());
        alarmCommandResponse.setSeverity(alarmCommandUpdateRequest.getSeverity());
        alarmCommandResponse.setReadonly(update.isReadOnly());
        alarmCommandResponse.setName(alarmCommandUpdateRequest.getName());
        alarmCommandResponse.setSeverity(alarmCommandUpdateRequest.getSeverity());
        return alarmCommandResponse;
    }

    /**
     * @param alarmCommand
     * @param alarmSeverity
     * @param alarmCommandUpdateRequest
     * @param id
     * @return
     */
    public static Alarm updateAlarmCommand(Optional<Alarm> alarmCommand, Optional<Integer> alarmSeverity,
                                    AlarmCommandUpdateRequest alarmCommandUpdateRequest, Integer id) {
        Alarm update = new Alarm();
        if (alarmCommand.isPresent() && alarmSeverity.isPresent()) {
            update.setId(alarmCommand.get().getId());
            update.setName(alarmCommandUpdateRequest.getName());
            update.setReadOnly(alarmCommand.get().isReadOnly());
            update.setProductTypeId(alarmCommand.get().getProductTypeId());
            update.setSeverityId(alarmSeverity.get());
        } else {
            AlarmCommandCheckUtils.throwErrorIfExists(AlarmCommandConstants.NOT_FOUND + id);
        }
        return update;
    }
}
