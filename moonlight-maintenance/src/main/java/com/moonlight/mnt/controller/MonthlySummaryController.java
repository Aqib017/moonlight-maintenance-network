package com.moonlight.mnt.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moonlight.mnt.entity.MonthlySummary;
import com.moonlight.mnt.service.MonthlySummaryService;
@RestController
@RequestMapping("/monthly-summary")
public class MonthlySummaryController {

    @Autowired
    private MonthlySummaryService service;

    @GetMapping
    public List<MonthlySummary> getAll() {
        return service.getAll();
    }
    @PostMapping
    public MonthlySummary create(@RequestBody MonthlySummary summary) {
        return service.save(summary);
    }
}