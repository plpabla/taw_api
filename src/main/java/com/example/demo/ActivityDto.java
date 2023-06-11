package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Value;

// @Value dodaje gettery i settery
// Można użyć @Data - zawiera więcej
@JsonSerialize
@Data
public class ActivityDto {
    @JsonProperty("id")
    Integer id;

    @JsonProperty("name")
    String name;

    // Nazwa jakiej chcemy uzywac w JSONie
    @JsonProperty("priority")
    Integer prio;

    public ActivityDto() {
        this.name = "empty";
        this.prio = 42;
    }

    public ActivityDto(Integer id, String name, Integer prio) {
        this.id = id;
        this.name = name;
        this.prio = prio;
    }
}
