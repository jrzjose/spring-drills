package com.micro.demo.web;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.demo.model.Tour;
import com.micro.demo.services.TourService;

// http://localhost:9090/api/tours/
@RestController
@RequestMapping("/api/tours")
//@Tag(name = "Tour Rating", description = "The Rating for a Tour API")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getAll() {
        return this.tourService.getAllTours();
    }
}
