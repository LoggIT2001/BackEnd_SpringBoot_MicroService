package HappyProject.Order_Service.Service.Implement;

import HappyProject.Order_Service.Exception.OrderNotFoundException;
import HappyProject.Order_Service.Mapper.OrderMapping;
import HappyProject.Order_Service.Model.DTO.OrderDTO;
import HappyProject.Order_Service.Repository.OrderRepository;
import HappyProject.Order_Service.Service.OrderService;
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
public class OrderImplement implements OrderService {

    private OrderRepository orderRepository;
    private RestTemplate restTemplate;

    @Override
    public List<OrderDTO> findAll() {
        log.info("OrderDTO find all order");
        return this.orderRepository.findAll().stream().map(OrderMapping::map).distinct().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public OrderDTO findById(Integer orderId) {
        log.info("OrderDTO find order by id");
        return this.orderRepository.findById(orderId).map(OrderMapping::map).orElseThrow(() -> new OrderNotFoundException(String.format("Order with id %d not found", orderId)));
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        log.info("OrderDTO save the order");
        return OrderMapping.map(this.orderRepository.save(OrderMapping.map(orderDTO)));
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        log.info("OrderDTO update the order");
        return OrderMapping.map(this.orderRepository.save(OrderMapping.map(orderDTO)));
    }

    @Override
    public OrderDTO update(Integer orderId, OrderDTO orderDTO) {
        log.info("OrderDTO save the order by id");
        return OrderMapping.map(this.orderRepository.save(OrderMapping.map(this.findById(orderId))));
    }

    @Override
    public void deleteById(Integer orderId) {
        log.info("OrderDTO delete by id");
        this.orderRepository.deleteById(orderId);
    }
}
