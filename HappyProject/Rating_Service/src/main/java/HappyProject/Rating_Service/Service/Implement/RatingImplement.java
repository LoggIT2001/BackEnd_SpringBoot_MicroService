package HappyProject.Rating_Service.Service.Implement;

import HappyProject.Rating_Service.Constant.AppConstant;
import HappyProject.Rating_Service.Exception.RatingNotFoundException;
import HappyProject.Rating_Service.Mapper.RatingMapping;
import HappyProject.Rating_Service.Model.DTO.ProductDTO;
import HappyProject.Rating_Service.Model.DTO.RatingDTO;
import HappyProject.Rating_Service.Model.DTO.UserDTO;
import HappyProject.Rating_Service.Model.Entity.RatingId;
import HappyProject.Rating_Service.Repository.RatingRepository;
import HappyProject.Rating_Service.Service.RatingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RatingImplement implements RatingService {

    private final RatingRepository ratingRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<RatingDTO> findAll() {
        log.info("RatingDTO, find all rating");
        return this.ratingRepository.findAll().stream().map(RatingMapping::map).map(f -> {
            f.setUserDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.USER_SERVICE_API_URL + "/" + f.getUserId(), UserDTO.class));
            f.setProductDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.PRODUCT_SERVICE_API_URL + "/" + f.getProductId(), ProductDTO.class));
            return f;
        }).distinct().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public RatingDTO findById(RatingId ratingId) {
        log.info("RatingDTO, find rating by id");
        return this.ratingRepository.findById(ratingId).map(RatingMapping::map).map(f ->{
            f.setUserDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.USER_SERVICE_API_URL + "/" + f.getUserId(), UserDTO.class));
            f.setProductDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.PRODUCT_SERVICE_API_URL + "/" + f.getProductId(), ProductDTO.class));
            return f;
        }).orElseThrow(() -> new RatingNotFoundException(String.format("Rating with id %s not found", ratingId)));
    }

    @Override
    public RatingDTO save(RatingDTO ratingDTO) {
        return RatingMapping.map(this.ratingRepository.save(RatingMapping.map(ratingDTO)));
    }

    @Override
    public RatingDTO update(RatingDTO ratingDTO) {
        return RatingMapping.map(this.ratingRepository.save(RatingMapping.map(ratingDTO)));
    }

    @Override
    public void deleteById(RatingId ratingId) {
        this.ratingRepository.deleteById(ratingId);
    }
}
