package HappyProject.Proxy_Client.Bussiness.Rating.Service;

import HappyProject.Proxy_Client.Bussiness.Rating.Model.DTO.RatingDTO;
import HappyProject.Proxy_Client.Bussiness.Rating.Model.RatingId;
import HappyProject.Proxy_Client.Bussiness.Rating.Model.Response.RatingCollectionRatingServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RatingService", contextId = "ratingClientService", path = "/RatingService/api/ratings")
public interface RatingClientService {
    @GetMapping
    ResponseEntity<RatingCollectionRatingServiceResponse> findAll();

    @GetMapping("/{userId}/{productId}")
    ResponseEntity<RatingDTO> findById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId);

    @GetMapping("/find")
    ResponseEntity<RatingDTO> findById(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final RatingId ratingId);

    @PostMapping
    public ResponseEntity<RatingDTO> save(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final RatingDTO ratingDTO);

    @PutMapping
    public ResponseEntity<RatingDTO> update(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final RatingDTO ratingDTO);

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") final String userId, @PathVariable("productId") final String productId);

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final RatingId ratingId);
}
