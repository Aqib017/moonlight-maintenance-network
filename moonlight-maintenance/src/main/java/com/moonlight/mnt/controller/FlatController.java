package com.moonlight.mnt.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.entity.Flat;
import com.moonlight.mnt.service.FlatService;

@RestController
@RequestMapping("/flats")
public class FlatController {

	    @Autowired
	    private FlatService flatService;

	    @PostMapping
	    public Flat addFlat(@RequestBody Flat flat) {
	        return flatService.addFlat(flat);
	    }
	    @GetMapping
	    public List<Flat> getAllFlats() {
	        return flatService.getAllFlats();
	    }
	    @PutMapping("/{id}")
	    public Flat updateFlat(@PathVariable Long id, @RequestBody Flat flat) {
	        return flatService.updateFlat(id,flat);
	    }

}
