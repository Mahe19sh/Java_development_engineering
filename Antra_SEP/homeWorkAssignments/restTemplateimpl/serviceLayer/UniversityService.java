package homeWorkAssignments.restTemplateimpl.serviceLayer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import homeWorkAssignments.restTemplateimpl.POJO.PojoA;
import homeWorkAssignments.restTemplateimpl.POJO.PojoB;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.*;


public class UniversityService {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://universities.hipolabs.com/search";

    public UniversityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Single country API request
    public List<PojoB> getUniversitiesByCountry(String country) {
        try {
            String url = BASE_URL + "?country=" + country;
            PojoA[] response = restTemplate.getForObject(url, PojoA[].class);
            if (response != null) {
                return List.of(response).stream()
                        .map(PojoA::getData)
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data for country: " + country, e);
        }
        return List.of();
    }

    // Multiple countries API request with multithreading
    public List<PojoB> getUniversitiesForMultipleCountries(List<String> countries) {
        ExecutorService executorService = Executors.newFixedThreadPool(10); // Adjust the pool size
        List<CompletableFuture<List<PojoB>>> futures = countries.stream()
                .map(country -> CompletableFuture.supplyAsync(() -> getUniversitiesByCountry(country), executorService))
                .collect(Collectors.toList());

        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
