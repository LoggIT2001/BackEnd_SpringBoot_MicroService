package HappyProject.Order_Service.Mapper;

import HappyProject.Order_Service.Model.DTO.CartDTO;
import HappyProject.Order_Service.Model.DTO.UserDTO;
import HappyProject.Order_Service.Model.Entity.Cart;

public interface CartMapping {
    public static CartDTO map(Cart cart) {

        return CartDTO.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .userDTO(UserDTO.builder()
                        .userId(cart.getUserId())
                        .build())
                .build();
    }

    public static Cart map(CartDTO cartDTO) {
        return Cart.builder()
                .cartId(cartDTO.getCartId())
                .userId(cartDTO.getUserId())
                .build();
    }
}
