package com.moonlight.mnt.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moonlight.mnt.entity.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{
	
	List<Expense>findByMonthAndYear(String month,Integer year);

}
