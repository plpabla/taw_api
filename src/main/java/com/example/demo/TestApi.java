package com.example.demo;

import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Rename endpoint - should be resoruce name. Action is defined with a method (GET/POST/DELETE/PUT)
@RestController
@RequestMapping("api")
public class TestApi {
    @Autowired
    private ActivitiesDB activitiesDB;
    private Integer activityCounter = 1;
    @GetMapping("/ping")
    public String ping()
    {
        return "Kopytko.";
    }

    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addActivity(@RequestBody ActivityDto activity)
    {
        activity.setId(activityCounter++);
        activitiesDB.add(activity);
    }

    @GetMapping(value="/list/all", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActivityDto>> activitiesListAll()
    {
        return ResponseEntity.ok(activitiesDB.getAll());
    }

    @GetMapping(value="/list", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActivityDto>> activitiesListFlt(
            @Nullable @RequestParam("prio") Integer prio,
            @Nullable @RequestParam("name") String name)
    {
        return ResponseEntity.ok(activitiesDB.getAll(prio=prio, name=name));
    }

    // TODO: Change `String id` to `Integer id`
    @GetMapping(value="/list/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActivityDto> activitiesList(@PathVariable(value="id") String id)
    {
        ActivityDto res = activitiesDB.getById(Integer.valueOf(id));
        if(res != null) {
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity activitiesList(@PathVariable(value="id") Integer id)
    {
        boolean res = activitiesDB.clean(id);
        if (res) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value= "/clean")
    public void deleteAll()
    {
        activitiesDB.clean();
    }
}
