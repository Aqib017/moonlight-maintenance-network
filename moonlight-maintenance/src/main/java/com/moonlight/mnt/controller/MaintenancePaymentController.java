package com.moonlight.mnt.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moonlight.mnt.entity.MaintenancePayment;
import com.moonlight.mnt.service.MaintenancePaymentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/payments")
public class MaintenancePaymentController {	
	
    @Autowired
    private MaintenancePaymentService paymentService;
    @PostMapping
    public MaintenancePayment addPayment(@Valid @RequestBody MaintenancePayment payment) {
        return paymentService.addPayment(payment);
    }
    @GetMapping
    public List<MaintenancePayment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    @GetMapping("/flat/{flatNumber}")
    public List<MaintenancePayment> getPaymentsByFlatNumber(@PathVariable String flatNumber) {
        return paymentService.getPaymentsByFlatNumber(flatNumber);
    }
    @GetMapping("/month/{month}/year/{year}")
    public List<MaintenancePayment> getPaymentsByFlatNumber(@PathVariable String month,@PathVariable Integer year) {
        return paymentService.getPaymentsByMonthAndYear(month,year);
    } 
    @GetMapping("/due")
    public List<MaintenancePayment> getDuePayments() {
        return paymentService.getDuePayments();
    }
    @GetMapping("/summary/{month}/{year}")
    public Double getMonthlyCollectionSummary(@PathVariable String month,@PathVariable Integer year) {
		return paymentService.getMonthlyCollectionSummary(month, year);
    }
    @PutMapping("/{id}")
    public MaintenancePayment updatePayment(@PathVariable Long id,@RequestBody MaintenancePayment payment) {
        return paymentService.updatePayment(id,payment);
    }
}

