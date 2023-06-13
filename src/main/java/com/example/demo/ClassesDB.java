package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// @Component definiuje, ze to jest bean (zarzadzalny obiekt w kontenerze Spring)
// @Scope definiuje cykl zycia - w tym przypadku singleton
@Component
@Scope("singleton")
public class ClassesDB {
    private List<ClassDto> classes = new ArrayList<>();

    public void add(ClassDto cl)
    {
        classes.add(cl);
    }

    public ClassDto getById(int id)
    {
        for(ClassDto el : classes)
        {
            if (el.getId().equals(id)) return el;
        }
        return null;
    }

    // TODO: Add filtering
    public List<ClassDto> get(String name, Integer ects, String room, String exam)
    {
        return classes;
    }

    public void clean()
    {
        classes.clear();
    }

    public boolean clean(Integer id)
    {
        return classes.removeIf(el -> el.getId()==id);
    }

}
