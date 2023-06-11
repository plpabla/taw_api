package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// @Component definiuje, ze to jest bean (zarzadzalny obiekt w kontenerze Spring)
// @Scope definiuje cykl zycia - w tym przypadku singleton
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

    public List<ActivityDto> getAll(Integer prio)
    {
        if(prio==null) return activities;

        List<ActivityDto> filteredActivities = activities.stream()
                .filter(el -> el.getPrio().equals(prio))
                .collect(Collectors.toList());


        return filteredActivities;
    }
    public void clean()
    {
        activities.clear();
    }

}
