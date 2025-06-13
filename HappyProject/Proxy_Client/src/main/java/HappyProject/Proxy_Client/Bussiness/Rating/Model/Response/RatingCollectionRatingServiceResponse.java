package HappyProject.Proxy_Client.Bussiness.Rating.Model.Response;

import HappyProject.Proxy_Client.Bussiness.Rating.Model.DTO.RatingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RatingCollectionRatingServiceResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Collection<RatingDTO> ratingDTOs;
}
