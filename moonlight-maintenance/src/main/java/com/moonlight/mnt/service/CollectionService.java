package com.moonlight.mnt.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.dto.DueReportDto;
import com.moonlight.mnt.entity.Collection;
import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.repository.CollectionRepository;
import com.moonlight.mnt.repository.FlatRepository;
@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private FlatRepository flatRepository;

	public Collection save(Collection collection) {
		boolean exists = collectionRepository.existsByFlatNumberAndMonthAndYear(collection.getFlatNumber(),
				collection.getMonth(), collection.getYear());
		if (exists) {
			throw new RuntimeException("Payment already exists for " + collection.getFlatNumber() + " "
					+ collection.getMonth() + " " + collection.getYear());
		}
		collection.setMonth(collection.getMonth().toUpperCase());
		return collectionRepository.save(collection);
	}
    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }
	public List<Collection> getCollectionsByFlat(String flatNumber) {
		return collectionRepository.findByFlatNumber(flatNumber);
	}
	public Double getTotalCollectionAmount() {
	    return collectionRepository.getTotalCollectionAmount();
	}
	public List<Collection> getCollectionsByMonthAndYear(String month, Integer year) {
		return collectionRepository.findByMonthAndYear(month, year);
	}
	public List<DueReportDto> getDueReport(String month, Integer year) {
		List<Flat> flats = flatRepository.findByActiveTrue();
		List<Collection> collections = collectionRepository.findByMonthAndYear(month, year);
		List<DueReportDto> report = new ArrayList<>();
		for (Flat flat : flats) {
			Double paidAmount = 0.0;
			for (Collection collection : collections) {
				if (flat.getFlatNumber().equals(collection.getFlatNumber())) {
					paidAmount += collection.getAmount();
				}
			}
			Double expectedAmount = flat.getMonthlyCharge();
			Double dueAmount = expectedAmount - paidAmount;
			report.add(new DueReportDto(flat.getFlatNumber(), expectedAmount, paidAmount, dueAmount));
		}
		return report;
	}
	public void deleteCollection(Long id) {
	    collectionRepository.deleteById(id);
	}
	public Collection updateCollection(Long id, Collection updatedCollection) {
		Collection existingCollection = collectionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Collection not found"));
		existingCollection.setFlatNumber(updatedCollection.getFlatNumber());
		existingCollection.setMonth(updatedCollection.getMonth().toUpperCase());
		existingCollection.setYear(updatedCollection.getYear());
		existingCollection.setAmount(updatedCollection.getAmount());
		existingCollection.setPaymentDate(updatedCollection.getPaymentDate());
		existingCollection.setRemarks(updatedCollection.getRemarks());
		return collectionRepository.save(existingCollection);
	}
	public Long getTotalCollectionsRecorded() {
		return collectionRepository.count();
	}
	public Double getTotalCollectionAmountByMonthAndYear(String month, Integer year) {
		return collectionRepository.getTotalCollectionAmountByMonthAndYear(month, year);
	}
}