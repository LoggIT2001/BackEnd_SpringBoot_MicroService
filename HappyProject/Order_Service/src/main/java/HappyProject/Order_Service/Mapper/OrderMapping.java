package HappyProject.Order_Service.Mapper;

import HappyProject.Order_Service.Model.DTO.CartDTO;
import HappyProject.Order_Service.Model.DTO.OrderDTO;
import HappyProject.Order_Service.Model.Entity.Cart;
import HappyProject.Order_Service.Model.Entity.Order;

public interface OrderMapping {
    public static OrderDTO map(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .orderDesc(order.getOrderDesc())
                .cartDTO(CartDTO.builder()
                        .cartId(order.getCart().getCartId())
                        .build())
                .build();
    }

    public static Order map(OrderDTO orderDTO) {
        return Order.builder()
                .orderId(orderDTO.getOrderId())
                .orderDate(orderDTO.getOrderDate())
                .orderDesc(orderDTO.getOrderDesc())
                .cart(Cart.builder()
                        .cartId(orderDTO.getCartDTO().getCartId())
                        .build())
                .build();
    }
}
