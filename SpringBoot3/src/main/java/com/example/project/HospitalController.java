package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;
    
    @GetMapping("hospitals/status")
    public String getStatus() {
    	return "Spring: status accepted.";
    }
    
    @GetMapping(value="hospitals/{id}")
	public ResponseEntity<Hospital> getHospital(@PathVariable("id") int id) throws Exception {
	    Hospital hospital = hospitalService.getHospital(id);
	    return ResponseEntity.status(HttpStatus.OK).body(hospital);
	}
	
    @GetMapping("hospitals")
	public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
    	List<Hospital> hospitalList = hospitalService.getAllHospitals();
		return hospitalList;
	}	
	
	@PostMapping(value="hospitals",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital  ) {
		hospitalService.addHospital(hospital);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("hospitals")
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		hospitalService.updateHospital(hospital);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping(value="hospitals",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {
		hospitalService.deleteHospital(hospital);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
