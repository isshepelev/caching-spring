package ru.isshepelev.cachingspring.service;

import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.isshepelev.cachingspring.model.MyRecord;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Service
public class HighloadService {
    @SneakyThrows
    @Cacheable(cacheNames = {"recordsCache"}, key = "#recordId")
    public MyRecord getOrCreateRecord(int recordId){
        TimeUnit.SECONDS.sleep(3L);
        return new MyRecord(recordId, LocalTime.now());
    }

    @CachePut(cacheNames = {"recordsCache"}, key = "#recordId")
    public MyRecord createOrUpdateRecord(int recordId){
        return new MyRecord(recordId, LocalTime.now());
    }

    @CacheEvict(cacheNames = {"recordsCache"}, key = "#recordId")
    public void deleteRecord(int recordId){}
}
