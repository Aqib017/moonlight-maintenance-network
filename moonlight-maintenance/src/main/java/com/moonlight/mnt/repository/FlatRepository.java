package com.moonlight.mnt.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moonlight.mnt.entity.Flat;
@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
	boolean existsByFlatNumber(String flatNumber);
	
	Optional<Flat> findByFlatNumber(String flatNumber);

}
