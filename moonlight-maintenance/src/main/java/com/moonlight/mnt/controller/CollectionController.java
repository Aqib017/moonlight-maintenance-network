package com.moonlight.mnt.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.CollectionSummaryDto;
import com.moonlight.mnt.dto.DueReportDto;
import com.moonlight.mnt.entity.Collection;
import com.moonlight.mnt.service.CollectionService;
@RestController
@RequestMapping("/api/collections")
@CrossOrigin(origins = "*")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PostMapping
	public Collection saveCollection(@RequestBody Collection collection) {
		return collectionService.save(collection);
	}
    @GetMapping
    public List<Collection> getAllCollections() {
        return collectionService.getAllCollections();
    }
	@GetMapping("/flat/{flatNumber}")
	public List<Collection> getCollectionsByFlat(@PathVariable String flatNumber) {
		return collectionService.getCollectionsByFlat(flatNumber);
	}
	@GetMapping("/summary")
	public CollectionSummaryDto getSummary() {
		return new CollectionSummaryDto(collectionService.getTotalCollectionAmount());
	}
	@GetMapping("/month/{month}/year/{year}")
	public List<Collection> getCollectionsByMonthAndYear(@PathVariable String month, @PathVariable Integer year) {
		return collectionService.getCollectionsByMonthAndYear(month, year);
	}
	@GetMapping("/due-report/month/{month}/year/{year}")
	public List<DueReportDto> getDueReport(@PathVariable String month, @PathVariable Integer year) {
		return collectionService.getDueReport(month, year);
	}
}