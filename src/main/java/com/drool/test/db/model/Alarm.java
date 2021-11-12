package com.drool.test.db.model;

import com.drool.test.db.model.enums.Priority;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Alarm {

    private UUID siteUUID;
    private String alarmID;
    private String siteName;
    private UUID companyUUID;
    private Long locationId;
    private UUID gatewayUUID;
    private String gatewayName;
    private String gatewayType;
    private String unitNumber;
    private UUID deviceUUID;
    private String deviceName;
    private UUID alarmUUID;
    private String alarmType;
    private LocalDateTime firstSignalled;
    private LocalDateTime acknowledged;
    private LocalDateTime cleared;
    private LocalDateTime received;
    private String alarmDescription;
    private Long duration;
    private int timesOccurred;
    private String misc;
    private LocalDateTime lastSignalled;
    private List<AuditTrail> auditTrail;
    private String alarmReason;
    private String assetModel;
    private boolean processed;

}
