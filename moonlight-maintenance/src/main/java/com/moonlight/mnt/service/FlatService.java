package com.moonlight.mnt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.exception.DuplicateFlatException;
import com.moonlight.mnt.repository.FlatRepository;

@Service
public class FlatService {
	
    @Autowired
    private FlatRepository flatRepository;

    public Flat addFlat(Flat flat) {
    	boolean flatExists = flatRepository.existsByFlatNumber(flat.getFlatNumber());
    	if(flatExists) {
    		throw new DuplicateFlatException("Flat already exists with flat number "+flat.getFlatNumber());
    	}
        return flatRepository.save(flat);
    }
    public List<Flat> getAllFlats() {

        return flatRepository.findAll();
    }
    public Flat updateFlat(Long id,Flat updatedFlat) {
        Flat existingFlat = flatRepository.findById(id).orElseThrow(()->new RuntimeException("Flat not found with id: "+ id));
        existingFlat.setOwnerName(updatedFlat.getOwnerName());
        existingFlat.setPhoneNumber(updatedFlat.getPhoneNumber());
        existingFlat.setFlatType(updatedFlat.getFlatType());
        existingFlat.setMonthlyCharge(updatedFlat.getMonthlyCharge());
        existingFlat.setActive(updatedFlat.getActive());
        return flatRepository.save(existingFlat);
    }
    public long getTotalFlats() {
        return flatRepository.count();
    }
    public Flat getFlatByFlatNumber(String flatNumber) {
        return flatRepository.findByFlatNumber(flatNumber).orElseThrow(() ->new RuntimeException("Flat not found: "
                                        + flatNumber));
    }
}
