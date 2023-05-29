package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ActivitiesDB {
    private List<ActivityDto> activities = new ArrayList<>();

    public void add(ActivityDto activity)
    {
        activities.add(activity);
    }

    public ActivityDto get(int idx)
    {
        return activities.get(idx);
    }

    public List<ActivityDto> getAll()
    {
        return activities;
    }

    public void clean()
    {
        activities.clear();
    }

}
