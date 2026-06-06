package com.moonlight.mnt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.DashboardSummaryResponse;
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

    public DashboardSummaryResponse getDashboardSummary(String month,Integer year) {

        DashboardSummaryResponse response = new DashboardSummaryResponse();
		MonthlySummary summary = monthlySummaryService.getByMonthAndYear(month, year);
		response.setMonth(month);
		response.setYear(year);
		response.setTotalFlats(flatService.getTotalFlats());
		response.setDuePayments(paymentService.getDuePaymentsCount());
		response.setTotalCollection(summary.getCollection());
		response.setTotalExpense(summary.getExpense());
		response.setBalance(summary.getClosingBalance());
        return response;
    }

}
