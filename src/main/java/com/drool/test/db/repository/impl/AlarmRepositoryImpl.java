package com.drool.test.db.repository.impl;

import com.drool.test.db.model.Alarm;
import com.drool.test.db.repository.AlarmRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class AlarmRepositoryImpl implements AlarmRepository {

    static List<Alarm> alarms = new ArrayList<>();

    @Override
    public List<Alarm> getAlarms() {
        return alarms;
    }

    @Override
    public Alarm getAlarmById(UUID id) {
        return alarms.stream().filter(a -> a.getAlarmUUID().equals(id)).findFirst().get();
    }

    @Override
    public Alarm createAlarm(Alarm alarm) {
        alarms.add(alarm);
        return alarm;
    }


    @Override
    public void deleteAlarm(Alarm alarm) {
        alarms.remove(alarm);
    }
}
