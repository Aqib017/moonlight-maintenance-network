package com.moonlight.mnt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.entity.Expense;
import com.moonlight.mnt.repository.ExpenseRepository;
@Service
public class ExpenseService {
	@Autowired 
	private ExpenseRepository expenseRepository;
	
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	public List<Expense>getAllExpenses() {
		return expenseRepository.findAll();
	}
	public Double getMonthlyExpenseSummary(String month,Integer year) {
		List<Expense> expenses = expenseRepository.findByMonthAndYear(month,year);
	    return expenses.stream().mapToDouble(Expense::getAmount).sum();
	}
	public Expense updateExpense(Long id,Expense updatedExpense) {
	    Expense existingExpense = expenseRepository.findById(id).orElseThrow(() ->new RuntimeException(
	                                    "Expense not found with id: "+ id));
	    existingExpense.setExpenseName(updatedExpense.getExpenseName());
	    existingExpense.setAmount(updatedExpense.getAmount());
	    existingExpense.setExpenseDate(updatedExpense.getExpenseDate());
	    existingExpense.setRemarks(updatedExpense.getRemarks());
	    existingExpense.setMonth(updatedExpense.getMonth());
	    existingExpense.setYear(updatedExpense.getYear());
	    return expenseRepository.save(existingExpense);
	}
	public List<Expense> getExpensesByMonthAndYear(String month, Integer year) {
		return expenseRepository.findByMonthAndYear(month, year);
	}
}
