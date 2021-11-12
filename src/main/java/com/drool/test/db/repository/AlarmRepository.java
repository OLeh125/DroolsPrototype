package com.drool.test.db.repository;

import com.drool.test.db.model.Alarm;
import java.util.List;
import java.util.UUID;

public interface AlarmRepository {
    List<Alarm> getAlarms();
    Alarm getAlarmById(UUID id);
    Alarm createAlarm(Alarm alarm);
    void deleteAlarm(Alarm alarm);
}
