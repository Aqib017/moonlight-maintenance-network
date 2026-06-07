package com.moonlight.mnt.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moonlight.mnt.entity.Expense;
import com.moonlight.mnt.service.ExpenseService;
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping
	public Expense addexpense(@RequestBody Expense expense) {
		return expenseService.addExpense(expense);
	}
	@GetMapping
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
	@GetMapping("/summary/{month}/{year}")
	public Double getMonthlyExpenseSummary(@PathVariable String month,@PathVariable Integer year) {
		return expenseService.getMonthlyExpenseSummary(month,year);
	}
	@PutMapping("/{id}")
	public Expense updateExpense(@PathVariable Long id,@RequestBody Expense expense) {
		return expenseService.updateExpense(id,expense);
	}
	@DeleteMapping("/{id}")
	public void deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
	}

}
