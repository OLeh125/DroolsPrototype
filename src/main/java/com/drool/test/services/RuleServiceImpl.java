package com.drool.test.services;

import com.drool.test.db.model.Alarm;

import com.drool.test.db.model.TimeRange;
import com.drool.test.db.repository.AlarmRepository;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RuleServiceImpl implements RuleService{

    private AlarmRepository alarmRepository;

    @Override
    public synchronized boolean isClosedIn(long time, Alarm alarm)
        throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Boolean> closed = executorService.submit(() -> {
            boolean isClosed = false;
            Thread.sleep(time);
            Alarm alarmById = alarmRepository.getAlarmById(alarm.getAlarmUUID());
            if (alarmById.getCleared() != null) {
                isClosed = true;
            }
            return isClosed;
        });
        return closed.get();
    }

    @Override
    public boolean raisedInToTimeRange(Alarm alarm, TimeRange range) {
        return alarm.getReceived().isAfter(range.getFrm()) && alarm.getReceived().isBefore(range.getTo());
    }

    @Override
    public void sendToTopic1(Alarm alarm) {
        log.info("sent to topic 1 : {}", alarm );
    }

    @Override
    public void sendToTopic2(Alarm alarm) {
        log.info("sent to topic 2 : {}", alarm );
    }

    @Override
    public void sendToTopic3(Alarm alarm) {
        log.info("sent to topic 3 : {}", alarm );
    }

    @Override
    public void sendToTopic4(Alarm alarm) {
        log.info("sent to topic 4 : {}", alarm );
    }

    @Override
    public void sendToTopic5(Alarm alarm) {
        log.info("sent to topic 5 : {}", alarm );
    }

    @Override
    public void sendToTopic6(Alarm alarm) {
        log.info("sent to topic 6 : {}", alarm );
        alarm.setProcessed(true);
    }

    @Override
    public void sendToTopic7(Alarm alarm) {
        log.info("sent to topic 7 : {}", alarm );
    }
}
