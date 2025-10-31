package com.micro.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.demo.model.Tour;
import com.micro.demo.model.enums.Difficulty;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tours", description = "The Tour API")
public interface TourRepository extends JpaRepository<Tour, Integer> {
    List<Tour> findByDifficulty(Difficulty diff);

    List<Tour> findByTourPackageCode(String code);
}