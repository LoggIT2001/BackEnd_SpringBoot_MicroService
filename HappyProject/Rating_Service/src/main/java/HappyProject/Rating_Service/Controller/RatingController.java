package HappyProject.Rating_Service.Controller;

import HappyProject.Rating_Service.Model.DTO.RatingDTO;
import HappyProject.Rating_Service.Model.Entity.RatingId;
import HappyProject.Rating_Service.Model.Response.DTOCollectionResponse;
import HappyProject.Rating_Service.Service.RatingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/rating")
@Slf4j
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<DTOCollectionResponse<RatingDTO>> findAll(){
        log.info("Rating Controller find all rating");
        return ResponseEntity.ok(new DTOCollectionResponse<>(this.ratingService.findAll()));
    }

    @GetMapping("/{userId}/{productId}")
    public ResponseEntity<RatingDTO> findById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId){
        log.info("RatingDTO Controller find rating by id");
        return ResponseEntity.ok(this.ratingService.findById(new RatingId(Integer.parseInt(userId), Integer.parseInt(productId))));
    }

    @GetMapping("/find")
    public ResponseEntity<RatingDTO> findById(@RequestBody @NotNull(message = "Input must not be null") @Valid final RatingId ratingId){
        log.info("RatingDTO Controller find rating by Id");
        return ResponseEntity.ok(this.ratingService.findById(ratingId));
    }

    @PostMapping
    public ResponseEntity<RatingDTO> save(@RequestBody @NotNull(message = "Input must not be null") @Valid RatingDTO ratingDTO){
        log.info("RatingDTO Controller save the rating");
        return ResponseEntity.ok(this.ratingService.save(ratingDTO));
    }

    @PutMapping
    public ResponseEntity<RatingDTO> update(@RequestBody @NotNull(message = "Input must not be null") @Valid RatingDTO ratingDTO){
        log.info("RatingDTO Controller save the rating");
        return ResponseEntity.ok(this.ratingService.update(ratingDTO));
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId){
        log.info("RatingDTO Controller delete rating by id");
        this.ratingService.deleteById(new RatingId(Integer.parseInt(userId), Integer.parseInt(productId)));
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestBody @NotNull(message = "Input must not be null") @Valid final RatingId ratingId){
        log.info("RatingDTO Controller delete rating by id");
        this.ratingService.deleteById(ratingId);
        return ResponseEntity.ok(true);
    }
}
