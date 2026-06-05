package com.moonlight.mnt.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.entity.MonthlySummary;
import com.moonlight.mnt.repository.MonthlySummaryRepository;
@Service
public class MonthlySummaryService {

    @Autowired
    private MonthlySummaryRepository repository;

    public List<MonthlySummary> getAll() {
        return repository.findAll();
    }
    public MonthlySummary save(MonthlySummary summary) {
        return repository.save(summary);
    }
}