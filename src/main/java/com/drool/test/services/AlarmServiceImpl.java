package com.drool.test.services;

import com.drool.test.db.model.Alarm;
import com.drool.test.db.repository.AlarmRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlarmServiceImpl implements AlarmService {

    private final AlarmRepository alarmRepository;

    @Override
    public List<Alarm> getAlarms() {
        log.info("get alarms");
        return alarmRepository.getAlarms();
    }

    @Override
    public Alarm getAlarmById(UUID id) {
        log.info("get Alarm by id");
        return alarmRepository.getAlarmById(id);
    }

    @Override
    public Alarm createAlarm(Alarm alarm) {
        log.info("create Alarm");
        return alarmRepository.createAlarm(alarm);
    }

    @Override
    public void deleteAlarm(Alarm alarm) {
        log.info("delete alarm");
        alarmRepository.deleteAlarm(alarm);
    }

}
