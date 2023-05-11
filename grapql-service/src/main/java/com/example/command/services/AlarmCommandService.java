package com.example.command.services;

import com.example.command.constants.AlarmCommandConstants;
import com.example.command.dtos.AlarmCommandRequest;
import com.example.command.dtos.AlarmCommandUpdateRequest;
import com.example.command.entity.Alarm;
import com.example.command.repository.AlarmCommandRepository;
import com.example.command.repository.AlarmSeverityQueryRepository;
import com.example.command.repository.ProductTypeRepository;
import com.example.command.repository.PropositionRepository;
import com.example.command.utls.AlarmCommandCheckUtils;
import com.example.command.utls.AlarmCommandCreateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlarmCommandService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private PropositionRepository propositionRepository;

    @Autowired
    private AlarmSeverityQueryRepository alarmSeverityQueryRepository;

    @Autowired
    private AlarmCommandRepository alarmCommandRepository;

    public Alarm saveCommand(AlarmCommandRequest alarmCommandRequest) {
        final Alarm alarmCommand = new Alarm();
        /** checks for proposition in DB **/
        final Optional<Integer> propositionId = propositionRepository.getIdByName(alarmCommandRequest.getBusiness());
        AlarmCommandCheckUtils.isPropositionExists(propositionId, alarmCommand, AlarmCommandConstants.PROPOSITION_NOT);
        /** checks for product Type in DB **/
        final Optional<Integer> productTypeId = productTypeRepository.getIdByName(alarmCommandRequest.getProductType());
        AlarmCommandCheckUtils.isProductTypeExists(productTypeId, alarmCommand, AlarmCommandConstants.PRODUCT_NOT);
        /** checks for severity in DB **/
        final Optional<Integer> severityId = alarmSeverityQueryRepository
                                        .getIdByName(alarmCommandRequest.getSeverity());
        AlarmCommandCheckUtils.isSeverityExists(severityId, alarmCommand, AlarmCommandConstants.SEVERITY_NOT);
        /** inserts alarm in DB **/
        return alarmCommandRepository.save(AlarmCommandCreateUtils.alarmCommand(alarmCommandRequest,
                                        productTypeId.get(), severityId.get()));

    }

    public Alarm updateCommand(AlarmCommandUpdateRequest updateRequest, Integer id) {
        final Optional<Alarm> alarmCommand = alarmCommandRepository.findById(id);
        final Optional<Integer> alarmSeverity = alarmSeverityQueryRepository.getIdByName(updateRequest.getSeverity());
        final Alarm update = AlarmCommandCreateUtils.updateAlarmCommand(alarmCommand, alarmSeverity, updateRequest, id);
        return alarmCommandRepository.save(update);

    }

    public Boolean deleteCommand(Integer id) {
        alarmCommandRepository.deleteById(id);
        return true;
    }
}
