package com.moonlight.mnt.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.moonlight.mnt.entity.MonthlySummary;
import com.moonlight.mnt.repository.MonthlySummaryRepository;
@Component
public class HistoricalDataLoader implements CommandLineRunner {

    private final MonthlySummaryRepository repository;

    public HistoricalDataLoader(MonthlySummaryRepository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... args) {
		if (repository.count() == 0) {
			repository.save(createSummary("JAN", 2024, 0.0, 25760.0, 21110.0, 4650.0));
			repository.save(createSummary("FEB", 2024, 4650.0, 15750.0, 18380.0, 2020.0));
			System.out.println("Historical monthly summaries loaded.");
        }
    }
	private MonthlySummary createSummary(String month, Integer year, Double opening, Double collection, Double expense,
			Double closing) {
		MonthlySummary summary = new MonthlySummary();
		summary.setMonth(month);
		summary.setYear(year);
		summary.setOpeningBalance(opening);
		summary.setCollection(collection);
		summary.setExpense(expense);
		summary.setClosingBalance(closing);
		return summary;
	}
}