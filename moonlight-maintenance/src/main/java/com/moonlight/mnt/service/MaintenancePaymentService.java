package com.moonlight.mnt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.entity.MaintenancePayment;
import com.moonlight.mnt.enums.PaymentStatus;
import com.moonlight.mnt.exception.DuplicatePaymentException;
import com.moonlight.mnt.repository.MaintenancePaymentRepository;
@Service
public class MaintenancePaymentService {
	
    @Autowired
    private MaintenancePaymentRepository paymentRepository;

    public MaintenancePayment addPayment(MaintenancePayment payment) {
        boolean paymentExists = paymentRepository.existsByFlatNumberAndMonthAndYear(payment.getFlatNumber(),
        						payment.getMonth(),payment.getYear());
        if(paymentExists) { 
        	throw new DuplicatePaymentException("Payment already exists for flat "+payment.getFlatNumber()
                            +" for "+payment.getMonth()+" "+payment.getYear());
        }
        return paymentRepository.save(payment);
    }
    public List<MaintenancePayment> getAllPayments() {
        return paymentRepository.findAll();
    }
    public List<MaintenancePayment> getPaymentsByFlatNumber(String flatNumber) {
        return paymentRepository.findByFlatNumber(flatNumber);
    }
    public List<MaintenancePayment> getPaymentsByMonthAndYear(String month,Integer year) {
        return paymentRepository.findByMonthAndYear(month,year);
    } 
    public List<MaintenancePayment> getDuePayments() {
        return paymentRepository.findByPaymentStatus(PaymentStatus.DUE);
    }
    public Double getMonthlyCollectionSummary(String month,Integer year) {
        List<MaintenancePayment>payments =paymentRepository.findByMonthAndYearAndPaymentStatus(month,year,PaymentStatus.PAID);
        return payments.stream().mapToDouble(MaintenancePayment::getAmount).sum();
    }
    public MaintenancePayment updatePayment(Long id,MaintenancePayment updatedPayment) {
        MaintenancePayment existingPayment = paymentRepository.findById(id).orElseThrow(()->new RuntimeException(
                                        "Payment not found with id: "+ id));
        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
        existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
        existingPayment.setRemarks(updatedPayment.getRemarks());
        return paymentRepository.save(existingPayment);
    }
    public long getDuePaymentsCount() {
        return paymentRepository.countByPaymentStatus(PaymentStatus.DUE);
    }
	public long getTotalPaymentsByFlat(String flatNumber) {
		return paymentRepository.findByFlatNumber(flatNumber).size();
	}
	public long getDuePaymentsByFlat(String flatNumber) {
		return paymentRepository.findByFlatNumber(flatNumber).stream().filter(payment ->
		payment.getPaymentStatus()== PaymentStatus.DUE).count();
	}
	public double getOutstandingAmount(String flatNumber) {
		return paymentRepository.findByFlatNumber(flatNumber).stream().filter(payment ->
		payment.getPaymentStatus()==PaymentStatus.DUE).mapToDouble(MaintenancePayment::getAmount).sum();
	}
	public List<String> getDueMonths(String flatNumber) {
		return paymentRepository.findByFlatNumber(flatNumber).stream().filter(payment -> payment.getPaymentStatus()
						==PaymentStatus.DUE).map(payment ->payment.getMonth() + "-" + payment.getYear()).toList();
	}
}
