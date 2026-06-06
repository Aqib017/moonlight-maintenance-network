package com.moonlight.mnt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.dto.MonthlyStatementResponse;
import com.moonlight.mnt.entity.Expense;
import com.moonlight.mnt.entity.MaintenancePayment;
import com.moonlight.mnt.entity.MonthlySummary;
@Service
public class MonthlyStatementService {
	
	@Autowired
	private MaintenancePaymentService paymentService;

	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private MonthlySummaryService monthlySummaryService;

	public MonthlyStatementResponse getMonthlyStatement(String month, Integer year) {

		List<MaintenancePayment> payments = paymentService.getPaymentsByMonthAndYear(month, year);
		List<Expense> expenses = expenseService.getExpensesByMonthAndYear(month, year);
		MonthlySummary summary = monthlySummaryService.getByMonthAndYear(month, year);
		MonthlyStatementResponse response = new MonthlyStatementResponse();

		response.setMonth(month);
		response.setYear(year);
		response.setPayments(payments);
		response.setExpenses(expenses);
		response.setTotalCollection(summary.getCollection());
		response.setTotalExpense(summary.getExpense());
		response.setBalance(summary.getClosingBalance());
		return response;
	}
}
