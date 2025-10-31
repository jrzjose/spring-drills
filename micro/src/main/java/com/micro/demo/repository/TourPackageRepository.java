package com.micro.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.micro.demo.model.TourPackage;

import io.swagger.v3.oas.annotations.tags.Tag;

@RepositoryRestResource(path = "packages", collectionResourceRel = "packages")
@Tag(name = "Tour Package", description = "The Tour Package API")
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
    Optional<TourPackage> findByName(String name);
}
