package com.example.demo;

import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TestApi {
    @Autowired
    private ClassesDB classesDB;
    private Integer addedItemsCounter = 1;
    @GetMapping("/ping")
    public String ping()
    {
        return "A skad to to znasz ten endpoint? haker, czy co?";
    }

    @PostMapping(value="/zajecia", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClass(@RequestBody ClassDto newClass)
    {
        newClass.setId(addedItemsCounter++);
        classesDB.add(newClass);
    }

    @GetMapping(value="/zajecia", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClassDto>> getClasses(
            @Nullable @RequestParam("nazwa") String name,
            @Nullable @RequestParam("ects") Integer ects,
            @Nullable @RequestParam("sala") String room,
            @Nullable @RequestParam("egzamin") String exam
            )
    {
        return ResponseEntity.ok(classesDB.get(name, ects, room, exam));
    }


}
