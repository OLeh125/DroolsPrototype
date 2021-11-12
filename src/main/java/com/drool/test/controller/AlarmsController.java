package com.drool.test.controller;

import com.drool.test.db.model.Alarm;
import com.drool.test.db.model.RulesParameters;
import com.drool.test.db.model.TimeRange;
import com.drool.test.services.AlarmService;
import com.drool.test.services.RuleService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "v1/alarms", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class AlarmsController {

    private final AlarmService alarmService;
    private final KieContainer kieContainer;
    private final RuleService ruleService;

    @GetMapping
    public List<Alarm> getAlarms(){
        log.info("get Alarms");
        return alarmService.getAlarms();
    }

    @PostMapping("/process")
    public Alarm processAlarm(@RequestBody Alarm alarm){
        log.info("process Alarm");
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(alarm);
        kieSession.setGlobal("alarmService", alarmService);
        kieSession.setGlobal("ruleService", ruleService);
        RulesParameters rulesParameters = RulesParameters.builder()
            .id(1122L)
            .alarmTypes(List.of("[Site] Test alarm","HCHECK"))
            .timeRange(new TimeRange(LocalDateTime.parse("2018-10-23T17:19:33"), LocalDateTime.now()))
            .assetModel(List.of("HVAC/Lights"))
            .companyUUIDs(List.of(UUID.fromString("8a14a86b-8927-45c7-b7e5-2ff96f2b73e3")))
            .minsToBeClosed(10000)
            .build();
        kieSession.setGlobal("ruleParameters",rulesParameters);
        kieSession.fireAllRules();
        return alarm;
    }

    @GetMapping("/alarm/{id}")
    public Alarm getAlarmById(@PathVariable UUID id) {
        log.info("get Alarm by id");
        return alarmService.getAlarmById(id);
    }

    @PostMapping
    public Alarm createAlarm(@RequestBody Alarm alarm) {
        log.info("create Alarm");
        return alarmService.createAlarm(alarm);
    }

    @DeleteMapping
    public void deleteAlarm(@RequestBody Alarm alarm) {
        log.info("delete Alarm");
        alarmService.deleteAlarm(alarm);
    }
}
