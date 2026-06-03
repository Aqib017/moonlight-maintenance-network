package com.moonlight.mnt.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moonlight.mnt.entity.MaintenancePayment;
import com.moonlight.mnt.enums.PaymentStatus;
@Repository
public interface MaintenancePaymentRepository extends JpaRepository<MaintenancePayment, Long>{
	
	List<MaintenancePayment>findByFlatNumber(String flatNumber);
	
	List<MaintenancePayment>findByMonthAndYear(String month,Integer year);
	
	List<MaintenancePayment>findByPaymentStatus(PaymentStatus paymentStatus);
	
	List<MaintenancePayment>findByMonthAndYearAndPaymentStatus(String month,Integer year,PaymentStatus paymentStatus);
	
	boolean existsByFlatNumberAndMonthAndYear(String flatNumber,String month,Integer year);
	
	long countByPaymentStatus(PaymentStatus paymentStatus);

}
