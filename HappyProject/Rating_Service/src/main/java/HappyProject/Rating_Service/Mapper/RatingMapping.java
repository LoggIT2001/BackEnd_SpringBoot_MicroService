package HappyProject.Rating_Service.Mapper;

import HappyProject.Rating_Service.Model.DTO.ProductDTO;
import HappyProject.Rating_Service.Model.DTO.RatingDTO;
import HappyProject.Rating_Service.Model.DTO.UserDTO;
import HappyProject.Rating_Service.Model.Entity.Rating;

public interface RatingMapping {
    public static RatingDTO map(final Rating rating){
        return RatingDTO.builder()
                .userId(rating.getUserId())
                .productId(rating.getProductId())
                .rate(rating.getRate())
                .comment(rating.getComment())
                .userDTO(
                    UserDTO.builder()
                            .userId(rating.getUserId())
                            .build())
                .productDTO(
                        ProductDTO.builder()
                                .productId(rating.getProductId())
                                .build())
                .build();
    }

    public static Rating map(final RatingDTO ratingDTO){
        return Rating.builder()
                .userId(ratingDTO.getUserId())
                .productId(ratingDTO.getProductId())
                .rate(ratingDTO.getRate())
                .comment(ratingDTO.getComment())
                .build();
    }
}
