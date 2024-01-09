package ru.isshepelev.cachingspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.cachingspring.model.MyRecord;
import ru.isshepelev.cachingspring.service.HighloadService;

@RestController
@RequiredArgsConstructor
public class HighloadController {
    private final HighloadService highloadService;


    @GetMapping("/{id}")
    public MyRecord getOrCreate(@PathVariable int id){
        return highloadService.getOrCreateRecord(id);
    }

    @PostMapping("/{id}")
    public MyRecord createOrUpdateRecord(@PathVariable int id){
        return highloadService.createOrUpdateRecord(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable int id){
        highloadService.deleteRecord(id);
    }
}
