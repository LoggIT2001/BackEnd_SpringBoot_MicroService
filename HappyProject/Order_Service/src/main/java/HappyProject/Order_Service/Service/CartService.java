package HappyProject.Order_Service.Service;

import HappyProject.Order_Service.Model.DTO.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> findAll();
    CartDTO findById(Integer cartId);
    CartDTO save(CartDTO cartDTO);
    CartDTO update(CartDTO cartDTO);
    CartDTO update(Integer cartId, CartDTO cartDTO);
    void deleteById(Integer cartId);
}
