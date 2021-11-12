package com.drool.test.services;

import com.drool.test.db.model.Alarm;
import com.drool.test.db.model.TimeRange;
import java.util.concurrent.ExecutionException;


public interface RuleService {

    boolean isClosedIn(long time, Alarm alarm) throws ExecutionException, InterruptedException;
    boolean raisedInToTimeRange(Alarm alarm, TimeRange range);
    void sendToTopic1(Alarm alarm);
    void sendToTopic2(Alarm alarm);
    void sendToTopic3(Alarm alarm);
    void sendToTopic4(Alarm alarm);
    void sendToTopic5(Alarm alarm);
    void sendToTopic6(Alarm alarm);
    void sendToTopic7(Alarm alarm);

}
