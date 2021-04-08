package com.example.services.impl;

import com.example.models.Log;
import com.example.repositories.LogRepository;
import com.example.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public int getSize() {
        return logRepository.findAll().size();
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public int getVisitorNumber(Integer id) {
        Log log = logRepository.findById(id).orElse(null);
        if (log != null) {
            return log.getVisitors();
        }
        return 0;
    }

    @Override
    public void addVisitor(Integer id) {
        Log log = logRepository.findById(id).orElse(null);
        if (log != null) {
            log.setVisitors(log.getVisitors() + 1);
            logRepository.save(log);
        }
    }
}
