package com.moonlight.mnt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.DashboardSummaryResponse;
@Service
public class DashboardService {
	
	@Autowired
    private FlatService flatService;

    @Autowired
    private MaintenancePaymentService paymentService;

    @Autowired
    private ExpenseService expenseService;

    public DashboardSummaryResponse getDashboardSummary(String month,Integer year) {

        DashboardSummaryResponse response = new DashboardSummaryResponse();
        Double totalCollection =  paymentService.getMonthlyCollectionSummary(month,year);
        Double totalExpense = expenseService.getMonthlyExpenseSummary(month,year);

        response.setMonth(month);
        response.setYear(year);
        response.setTotalFlats(flatService.getTotalFlats());
        response.setDuePayments(paymentService.getDuePaymentsCount());
        response.setTotalCollection(totalCollection);
        response.setTotalExpense(totalExpense);
        response.setBalance(totalCollection - totalExpense);
        return response;
    }

}
