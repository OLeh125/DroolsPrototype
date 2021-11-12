package com.drool.test.db.model.enums;

import com.drool.test.exceptions.InvalidValueException;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;

@Getter
@RequiredArgsConstructor
public enum Priority {

    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low"),
    ALL("All");

    public static final Map<String, Priority> VALUE_TO_ACK_STATE =
        Arrays.stream(Priority.values())
            .collect(Collectors.toMap(Priority::getValue, s -> s));

    private final String value;

    @JsonCreator
    public static Priority fromString(String state) {
        return Optional.ofNullable(EnumUtils.getEnumIgnoreCase(Priority.class, state))
            .orElseThrow(() -> new InvalidValueException("Illegal priority " + state));
    }

    public static Priority fromValue(String value) {
        return VALUE_TO_ACK_STATE.getOrDefault(value, ALL);
    }
}
