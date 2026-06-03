package com.moonlight.mnt.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.repository.FlatRepository;
@Component
public class DataLoader implements CommandLineRunner{
	private final FlatRepository flatRepository;

    public DataLoader(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }
    @Override
    public void run(String... args) {
        // Avoid duplicate insert
        if (flatRepository.count() == 0) {

            flatRepository.save(createFlat("1A", "A", 1600.0));
            flatRepository.save(createFlat("1B", "B", 1200.0));
            flatRepository.save(createFlat("2A", "A", 1600.0));
            flatRepository.save(createFlat("2B", "B", 1200.0));
            flatRepository.save(createFlat("3A", "A", 1600.0));
            flatRepository.save(createFlat("3B", "B", 1200.0));
            flatRepository.save(createFlat("4A", "A", 1600.0));
            flatRepository.save(createFlat("4B", "B", 1200.0));

            System.out.println("Moonlight Apartment flats inserted successfully!");
        }
    }
    private Flat createFlat(String flatNumber,
                            String flatType,
                            Double monthlyCharge) {
        Flat flat = new Flat();

        flat.setFlatNumber(flatNumber);
        flat.setFlatType(flatType);
        flat.setMonthlyCharge(monthlyCharge);
        flat.setOwnerName("Not Assigned");
        flat.setPhoneNumber("Not Available");
        flat.setActive(true);
        return flat;
    }
}
