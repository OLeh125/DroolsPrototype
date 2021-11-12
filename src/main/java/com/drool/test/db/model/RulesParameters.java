package com.drool.test.db.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RulesParameters {

    private Long id;
    private UUID ruleUUID;
    private List<UUID> companyUUIDs;
    private TimeRange timeRange;
    private List<String> controllerTypes;
    private List<String> assetModel;
    private List<String> alarmTypes;
    private long minsToBeClosed;
    private long timeOccurred;

}
