package com.moonlight.mnt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.moonlight.mnt.entity.MonthlySummary;

public interface MonthlySummaryRepository extends JpaRepository<MonthlySummary, Long> {

}