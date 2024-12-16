package homeWorkAssignments.restTemplateimpl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import homeWorkAssignments.restTemplateimpl.POJO.PojoB;
import homeWorkAssignments.restTemplateimpl.serviceLayer.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
     private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/by-country")
    public ResponseEntity<List<PojoB>> getUniversitiesByCountry(@RequestParam String country) {
        List<PojoB> response = universityService.getUniversitiesByCountry(country);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/by-multiple-countries")
    public ResponseEntity<List<PojoB>> getUniversitiesByMultipleCountries(@RequestBody List<String> countries) {
        List<PojoB> response = universityService.getUniversitiesForMultipleCountries(countries);
        return ResponseEntity.ok(response);
    }
}
