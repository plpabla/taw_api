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

    public List<ActivityDto> getAll(Integer prio, String name)
    {
        List<ActivityDto> filteredActivities = new ArrayList<>(activities);
        if(prio!=null) {
            filteredActivities = activities.stream()
                    .filter(el -> el.getPrio().equals(prio))
                    .collect(Collectors.toList());
        }

        if(name!=null) {
            filteredActivities = filteredActivities.stream()
                    .filter(el -> el.getName().equals(name))
                    .collect(Collectors.toList());
        }

        return filteredActivities;
    }
    public void clean()
    {
        activities.clear();
    }

}
