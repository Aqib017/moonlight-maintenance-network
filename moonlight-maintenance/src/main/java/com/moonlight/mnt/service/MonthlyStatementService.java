package com.moonlight.mnt.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.MonthlyStatementResponse;
import com.moonlight.mnt.entity.Expense;
import com.moonlight.mnt.entity.MaintenancePayment;
@Service
public class MonthlyStatementService {
	
	@Autowired
	private MaintenancePaymentService paymentService;

	@Autowired
	private ExpenseService expenseService;

	public MonthlyStatementResponse getMonthlyStatement(String month, Integer year) {

		List<MaintenancePayment> payments = paymentService.getPaymentsByMonthAndYear(month, year);
		List<Expense> expenses = expenseService.getExpensesByMonthAndYear(month, year);
		Double totalCollection = paymentService.getMonthlyCollectionSummary(month, year);
		Double totalExpense = expenseService.getMonthlyExpenseSummary(month, year);
		MonthlyStatementResponse response = new MonthlyStatementResponse();

		response.setMonth(month);
		response.setYear(year);
		response.setPayments(payments);
		response.setExpenses(expenses);
		response.setTotalCollection(totalCollection);
		response.setTotalExpense(totalExpense);
		response.setBalance(totalCollection - totalExpense);
		return response;
	}
}
