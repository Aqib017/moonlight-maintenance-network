package com.moonlight.mnt.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.moonlight.mnt.entity.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
	
	List<Collection> findByFlatNumber(String flatNumber);
	
	@Query("SELECT COALESCE(SUM(c.amount),0) FROM Collection c")
	Double getTotalCollectionAmount();
	
	List<Collection> findByMonthAndYear(String month, Integer year);

	boolean existsByFlatNumberAndMonthAndYear(String flatNumber, String month, Integer year);

}