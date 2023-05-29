package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

// @Value dodaje gettery i settery
@JsonSerialize
@Value
public class ActivityDto {

    @JsonProperty("name")
    private String name;

    // Nazwa jakiej chcemy uzywac w JSONie
    @JsonProperty("priority")
    private Integer prio;

    public ActivityDto() {
        this.name = "empty";
        this.prio = 42;
    }

    public ActivityDto(String name, Integer prio) {
        this.name = name;
        this.prio = prio;
    }
}
