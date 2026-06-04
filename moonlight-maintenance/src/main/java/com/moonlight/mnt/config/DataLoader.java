package com.moonlight.mnt.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.entity.User;
import com.moonlight.mnt.repository.FlatRepository;
import com.moonlight.mnt.repository.UserRepository;
@Component
public class DataLoader implements CommandLineRunner{
	private final FlatRepository flatRepository;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	public DataLoader(FlatRepository flatRepository, UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
		this.flatRepository = flatRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
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
		if (userRepository.findByUsername("admin").isEmpty()) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("moonlight123"));
			userRepository.save(admin);
			System.out.println("Admin user created!");
		}
    }
	private Flat createFlat(String flatNumber, String flatType, Double monthlyCharge) {
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
