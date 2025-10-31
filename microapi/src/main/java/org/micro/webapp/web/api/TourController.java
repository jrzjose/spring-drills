package org.micro.webapp.web.api;

import java.util.List;

import org.micro.webapp.data.service.TourService;
import org.micro.webapp.web.model.Tour;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
