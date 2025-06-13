package HappyProject.Order_Service.Service.Implement;

import HappyProject.Order_Service.Constant.AppConstant;
import HappyProject.Order_Service.Exception.CartNotFoundException;
import HappyProject.Order_Service.Mapper.CartMapping;
import HappyProject.Order_Service.Model.DTO.CartDTO;
import HappyProject.Order_Service.Model.DTO.UserDTO;
import HappyProject.Order_Service.Repository.CartRepository;
import HappyProject.Order_Service.Service.CartService;
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
public class CartImplement implements CartService {

    private CartRepository cartRepository;
    private RestTemplate restTemplate;

    @Override
    public List<CartDTO> findAll() {
        log.info("CartDTO find all the cart");
        return this.cartRepository.findAll().stream().map(CartMapping::map).map(cart -> {
            cart.setUserDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.USER_SERVICE_API_URL + "/" + cart.getUserDTO().getUserId(), UserDTO.class));
            return cart;
        }).distinct().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CartDTO findById(Integer cartId) {
        log.info("CartDTO, find cart by id");
        return this.cartRepository.findById(cartId).map(CartMapping::map).map(cart -> {
            cart.setUserDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.USER_SERVICE_API_URL + "/" + cart.getUserDTO().getUserId(), UserDTO.class));
            return cart;
        }).orElseThrow(() -> new CartNotFoundException(String.format("Cart with id: %d is not found", cartId)));
    }

    @Override
    public CartDTO save(CartDTO cartDTO) {
        log.info("CartDTO save the cart");
        return CartMapping.map(this.cartRepository.save(CartMapping.map(cartDTO)));
    }

    @Override
    public CartDTO update(CartDTO cartDTO) {
        log.info("CartDTO update the cart");
        return CartMapping.map(this.cartRepository.save(CartMapping.map(cartDTO)));
    }

    @Override
    public CartDTO update(Integer cartId, CartDTO cartDTO) {
        log.info("CartDTO update the cart by id");
        return CartMapping.map(this.cartRepository.save(CartMapping.map(this.findById(cartId))));
    }

    @Override
    public void deleteById(Integer cartId) {
        log.info("CartDTO delete the cart by id");
        this.cartRepository.deleteById(cartId);
    }
}
