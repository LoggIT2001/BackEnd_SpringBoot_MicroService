package HappyProject.Proxy_Client.Bussiness.Order.Service;

import HappyProject.Proxy_Client.Bussiness.Order.Model.DTO.OrderDTO;
import HappyProject.Proxy_Client.Bussiness.Order.Model.Response.OrderServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "OrderService", contextId = "orderClientService", url = "http://localhost:9052/Order_Service/api/orders")
public interface OrderClientService {
    @GetMapping
    public ResponseEntity<OrderServiceResponse> findAll();

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("orderId") @NotBlank @Valid final String orderId);

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody @NotNull @Valid OrderDTO orderDTO);

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody @NotNull @Valid OrderDTO orderDTO);

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") @NotBlank @Valid String orderId, @RequestBody @NotNull @Valid OrderDTO orderDTO);

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("orderId") @Valid String orderId);
}
