package HappyProject.Proxy_Client.Bussiness.OrderItem.Service;

import HappyProject.Proxy_Client.Bussiness.OrderItem.Model.DTO.OrderItemDTO;
import HappyProject.Proxy_Client.Bussiness.OrderItem.Model.DTO.OrderItemId;
import HappyProject.Proxy_Client.Bussiness.OrderItem.Model.Response.OrderItemServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderItemService {
    @GetMapping
    ResponseEntity<OrderItemServiceResponse> findAll();

    @GetMapping("/{orderId}/{productId}")
    ResponseEntity<OrderItemDTO> findById(@PathVariable("orderId") final String orderId, @PathVariable("productId") final String productId);

    @GetMapping("/find")
    ResponseEntity<OrderItemDTO> findById(@RequestBody @NotNull(message = "Input must not be empty") @Valid final OrderItemId orderItemId);

    @PostMapping
    ResponseEntity<OrderItemDTO> save(@RequestBody @NotNull(message = "Input must not be empty") @Valid OrderItemDTO orderItemDTO);

    @PutMapping
    ResponseEntity<OrderItemDTO> update(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final OrderItemDTO orderItemDto);

    @DeleteMapping("/{orderId}/{productId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("orderId") final String orderId, @PathVariable("productId") final String productId);

    @DeleteMapping("/delete")
    ResponseEntity<Boolean> deleteById(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final OrderItemId orderItemId);
}
