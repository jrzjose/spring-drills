package com.micro.demo.web;
// package com.micro.web;

// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;

// import com.micro.dtos.RatingDto;
// import com.micro.model.TourRating;
// import com.micro.services.TourRatingService;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import jakarta.validation.Valid;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.http.HttpStatus;

// @RestController
// @Slf4j
// @Tag(name = "Tour Rating", description = "The Rating for a Tour API")
// @RequestMapping(path = "/tours/{tourId}/ratings")
// public class TourRatingController {
//     private TourRatingService tourRatingService;

//     public TourRatingController(TourRatingService tourRatingService) {
//         this.tourRatingService = tourRatingService;
//     }

//     @PostMapping
//     @ResponseStatus(HttpStatus.CREATED)
//     @Operation(summary = "Create a Tour Rating")
//     public RatingDto createTourRating(@PathVariable(value = "tourId") int tourId,
//             @RequestBody @Valid RatingDto ratingDto) {

//         log.info("POST /tours/{}/ratings ", tourId);

//         TourRating rating = tourRatingService.createNew(tourId, ratingDto.getCustomerId(),
//                 ratingDto.getScore(), ratingDto.getComment());

//         return new RatingDto(rating);
//     }

//     @GetMapping
//     @Operation(summary = "Lookup All Ratings for a Tour")
//     public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {
        
//         log.info("GET /tours/{}/ratings", tourId);

//         List<TourRating> tourRatings = tourRatingService.lookupRatings(tourId);

//         return tourRatings.stream().map(RatingDto::new).toList();
//     }

//     @GetMapping("/average")
//     @Operation(summary = "Get the Average Score for a Tour")
//     public Map<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {

//         log.info("GET /tours/{}/ratings/average", tourId);

//         return Map.of("average", tourRatingService.getAverageScore(tourId));
//     }

//     @PutMapping
//     @Operation(summary = "Modify All Tour Rating Attributes")
//     public RatingDto updateWithPut(@PathVariable(value = "tourId") int tourId,
//             @RequestBody @Valid RatingDto ratingDto) {

//         log.info("PUT /tours/{}/ratings", tourId);

//         return new RatingDto(tourRatingService.update(tourId, ratingDto.getCustomerId(),
//                 ratingDto.getScore(), ratingDto.getComment()));
//     }

//     @PatchMapping
//     @Operation(summary = "Modify Some Tour Rating Attributes")
//     public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId,
//             @RequestBody @Valid RatingDto ratingDto) {

//         log.info("PATCH /tours/{}/ratings", tourId);

//         return new RatingDto(tourRatingService.updateSome(tourId,
//                 ratingDto.getCustomerId(),
//                 Optional.ofNullable(ratingDto.getScore()),
//                 Optional.ofNullable(ratingDto.getComment())));
//     }

//     @DeleteMapping("/{customerId}")
//     @Operation(summary = "Delete a Customer's Rating of a Tour")
//     public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {

//         log.info("DELETE /tours/{}/ratings/{}", tourId, customerId);

//         tourRatingService.delete(tourId, customerId);
//     }

//     @PostMapping("/batch")
//     @ResponseStatus(HttpStatus.CREATED)
//     @Operation(summary = "Give Many Tours Same Score")
//     public void createManyTourRatings(@PathVariable(value = "tourId") int tourId,
//             @RequestParam(value = "score") int score,
//             @RequestBody List<Integer> customers) {
        
//         log.info("POST /tours/{}/ratings/batch", tourId);

//         tourRatingService.rateMany(tourId, score, customers);
//     }
// }
