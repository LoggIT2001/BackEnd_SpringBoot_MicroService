package HappyProject.Proxy_Client.Bussiness.Rating.Controller;

import HappyProject.Proxy_Client.Bussiness.Rating.Model.DTO.RatingDTO;
import HappyProject.Proxy_Client.Bussiness.Rating.Model.RatingId;
import HappyProject.Proxy_Client.Bussiness.Rating.Model.Response.RatingCollectionRatingServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Rating.Service.RatingClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingClientService ratingClientService;

    @GetMapping
    public ResponseEntity<RatingCollectionRatingServiceResponse> findAll() {
        return ResponseEntity.ok(this.ratingClientService.findAll().getBody());
    }

    @GetMapping("/{userId}/{productId}/{likeDate}")
    public ResponseEntity<RatingDTO> findById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId) {
        return ResponseEntity.ok(this.ratingClientService.findById(userId, productId).getBody());
    }

    @GetMapping("/find")
    public ResponseEntity<RatingDTO> findById(@RequestBody final RatingId ratingId) {
        return ResponseEntity.ok(this.ratingClientService.findById(ratingId).getBody());
    }

    @PostMapping
    public ResponseEntity<RatingDTO> save(@RequestBody final RatingDTO ratingDTO) {
        return ResponseEntity.ok(this.ratingClientService.save(ratingDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<RatingDTO> update(@RequestBody final RatingDTO ratingDTO) {
        return ResponseEntity.ok(this.ratingClientService.update(ratingDTO).getBody());
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId) {
        this.ratingClientService.deleteById(userId, productId).getBody();
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestBody final RatingId ratingId) {
        this.ratingClientService.deleteById(ratingId).getBody();
        return ResponseEntity.ok(true);
    }
}
