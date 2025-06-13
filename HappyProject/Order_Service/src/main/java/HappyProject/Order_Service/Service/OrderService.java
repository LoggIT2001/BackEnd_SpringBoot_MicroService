package HappyProject.Order_Service.Service;

import HappyProject.Order_Service.Model.DTO.OrderDTO;
import HappyProject.Order_Service.Model.Entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
    OrderDTO findById(Integer orderId);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    OrderDTO update(Integer orderId, OrderDTO orderDTO);
    void deleteById(Integer orderId);
}
