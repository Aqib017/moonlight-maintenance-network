package com.moonlight.mnt.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.dto.DashboardSummaryResponse;
import com.moonlight.mnt.dto.RecentActivityDto;
import com.moonlight.mnt.entity.MonthlySummary;
@Service
public class DashboardService {
	
	@Autowired
    private FlatService flatService;

    @Autowired
    private MaintenancePaymentService paymentService;

    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
    private MonthlySummaryService monthlySummaryService;
    
    @Autowired
    private CollectionService collectionService;

    public DashboardSummaryResponse getDashboardSummary(String month,Integer year) {

        DashboardSummaryResponse response = new DashboardSummaryResponse();
		MonthlySummary summary = monthlySummaryService.getByMonthAndYear(month, year);
		response.setMonth(month);
		response.setYear(year);
		response.setTotalFlats(flatService.getTotalFlats());
		response.setDuePayments(paymentService.getDuePaymentsCount());
		if (summary != null) {
			response.setTotalCollection(summary.getCollection());
			response.setTotalExpense(summary.getExpense());
			response.setBalance(summary.getClosingBalance());
		} else {
			Double totalCollection = collectionService.getTotalCollectionAmountByMonthAndYear(month, year);
			Double totalExpense = expenseService.getMonthlyExpenseSummary(month, year);
			response.setTotalCollection(totalCollection);
			response.setTotalExpense(totalExpense);
			response.setBalance(totalCollection - totalExpense);
		}
		response.setTotalCollectionsRecorded(collectionService.getTotalCollectionsRecorded());
		List<RecentActivityDto> activities = new ArrayList<>();
		activities.add(new RecentActivityDto("4A paid ₹1600"));
		activities.add(new RecentActivityDto("3A paid ₹2600"));
		activities.add(new RecentActivityDto("Electricity Expense ₹1200"));
		response.setRecentActivities(activities);
        return response;
    }
    

}
