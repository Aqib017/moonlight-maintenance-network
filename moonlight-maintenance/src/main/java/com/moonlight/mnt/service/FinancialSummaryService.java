package com.moonlight.mnt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.FinancialSummaryResponse;
@Service
public class FinancialSummaryService {

	@Autowired
	private MaintenancePaymentService paymentService;
	@Autowired
	private ExpenseService expenseService;

	public FinancialSummaryResponse getFinancialSummary(String month, Integer year) {

		Double totalCollection = paymentService.getMonthlyCollectionSummary(month, year);
		Double totalExpense = expenseService.getMonthlyExpenseSummary(month, year);
		Double balance = totalCollection - totalExpense;
		FinancialSummaryResponse response = new FinancialSummaryResponse();

		response.setMonth(month);
		response.setYear(year);
		response.setTotalCollection(totalCollection);
		response.setTotalExpense(totalExpense);
		response.setBalance(balance);
		return response;
	}
}
