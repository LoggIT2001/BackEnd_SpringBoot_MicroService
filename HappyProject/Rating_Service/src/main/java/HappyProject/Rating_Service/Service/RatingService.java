package HappyProject.Rating_Service.Service;

import HappyProject.Rating_Service.Model.DTO.RatingDTO;
import HappyProject.Rating_Service.Model.Entity.RatingId;

import java.util.List;

public interface RatingService {
    List<RatingDTO> findAll();
    RatingDTO findById(final RatingId ratingId);
    RatingDTO save(final RatingDTO ratingDTO);
    RatingDTO update(final RatingDTO ratingDTO);
    void deleteById(final RatingId ratingId);
}
