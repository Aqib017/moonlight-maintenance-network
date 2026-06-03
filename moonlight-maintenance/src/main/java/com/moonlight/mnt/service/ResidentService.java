package com.moonlight.mnt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.dto.ResidentSummaryResponse;
import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.entity.MaintenancePayment;
@Service
public class ResidentService {
	
	 @Autowired
	    private FlatService flatService;

	    @Autowired
	    private MaintenancePaymentService paymentService;

		public ResidentSummaryResponse getResidentSummary(String flatNumber) {

			Flat flat = flatService.getFlatByFlatNumber(flatNumber);
			List<MaintenancePayment> payments = paymentService.getPaymentsByFlatNumber(flatNumber);
			ResidentSummaryResponse response = new ResidentSummaryResponse();

			response.setFlatNumber(flat.getFlatNumber());
			response.setOwnerName(flat.getOwnerName());
			response.setPhoneNumber(flat.getPhoneNumber());
			response.setMonthlyCharge(flat.getMonthlyCharge());
			response.setActive(flat.getActive());
			response.setTotalPayments(paymentService.getTotalPaymentsByFlat(flatNumber));
			response.setDuePayments(paymentService.getDuePaymentsByFlat(flatNumber));
			response.setOutstandingAmount(paymentService.getOutstandingAmount(flatNumber));
			response.setDueMonths(paymentService.getDueMonths(flatNumber));
			response.setPaymentHistory(payments);
			return response;
		}

}
