package com.micro.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.demo.model.Tour;
import com.micro.demo.model.TourPackage;
import com.micro.demo.model.enums.Difficulty;
import com.micro.demo.model.enums.Region;
import com.micro.demo.repository.TourPackageRepository;
import com.micro.demo.repository.TourRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TourService {

    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String tourPackageName, String title,
            String description, String blurb, Integer price, String duration,
            String bullets, String keywords, Difficulty difficulty, Region region) {

        log.info("Create tour {} for package {}", title, tourPackageName);

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package not found for id:" + tourPackageName));

        return tourRepository
            .save(new Tour(title, description, blurb, price, duration, bullets, 
                keywords, tourPackage, difficulty, region));
    }

    public List<Tour> lookupByDifficulty(Difficulty difficulty) {
        
        log.info("Lookup tours by difficulty {}", difficulty);

        return tourRepository.findByDifficulty(difficulty);
    }

    public List<Tour> lookupByPackage(String tourPackageCode) {

        log.info("Lookup tour by code {}", tourPackageCode);

        return tourRepository.findByTourPackageCode(tourPackageCode);
    }

    public long total() {
        
        log.info("Get total tours");

        return tourRepository.count();
    }
    
    public List<Tour> getAllTours() {
        List<Tour> entities = this.tourRepository.findAll();
        
        log.info("Get All Tours");

        return entities;
    }
}
