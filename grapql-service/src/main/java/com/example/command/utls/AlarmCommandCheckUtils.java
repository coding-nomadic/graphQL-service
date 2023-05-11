package com.example.command.utls;

import com.example.command.entity.Alarm;
import com.example.command.exceptions.AlarmCommandException;
import com.example.command.exceptions.AlarmDuplicateException;
import com.example.command.exceptions.AlarmNotFoundException;

import java.util.Optional;

/**
 * Util class to check for porameters present in DB.
 */
public class AlarmCommandCheckUtils {
    private AlarmCommandCheckUtils() {

    }

    public static Alarm throwErrorIfExists(String message) {
        throw new AlarmCommandException(message);
    }

    public static Alarm throwAlarmNotFoundError(String message) {
        throw new AlarmNotFoundException(message);
    }

    public static Alarm throwAlarmDuplicateError(String message) {
        throw new AlarmDuplicateException(message);
    }

    public static Alarm isPropositionExists(Optional<Integer> propositionId, Alarm alarmCommand, String message) {
        return !propositionId.isPresent() ? throwErrorIfExists(message) : alarmCommand;
    }

    public static Alarm isProductTypeExists(Optional<Integer> productTypeId, Alarm alarmCommand, String message) {
        return productTypeId.isPresent() ? alarmCommand : throwErrorIfExists(message);
    }

    public static Alarm isSeverityExists(Optional<Integer> severityId, Alarm alarmCommand, String message) {
        return severityId.isPresent() ? alarmCommand : throwErrorIfExists(message);
    }

    public static Alarm isAlarmExists(Optional<Alarm> alarmCommand, String message) {
        return !alarmCommand.isPresent() ? throwAlarmNotFoundError(message) : new Alarm();
    }
}
