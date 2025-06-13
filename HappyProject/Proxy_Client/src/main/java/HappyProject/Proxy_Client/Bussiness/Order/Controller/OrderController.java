package HappyProject.Proxy_Client.Bussiness.Order.Controller;

import HappyProject.Proxy_Client.Bussiness.Order.Model.DTO.OrderDTO;
import HappyProject.Proxy_Client.Bussiness.Order.Model.Response.OrderServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Order.Service.OrderClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderClientService orderClientService;

    @GetMapping
    public ResponseEntity<OrderServiceResponse> findAll(){
        return ResponseEntity.ok(this.orderClientService.findAll().getBody());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("orderId") @NotBlank @Valid final String orderId){
        return ResponseEntity.ok(this.orderClientService.findById(orderId).getBody());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody @NotNull @Valid OrderDTO orderDTO){
        return ResponseEntity.ok(this.orderClientService.save(orderDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody @NotNull @Valid OrderDTO orderDTO){
        return ResponseEntity.ok(this.orderClientService.update(orderDTO).getBody());
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") @NotBlank @Valid String orderId, @RequestBody @NotNull @Valid OrderDTO orderDTO){
        return ResponseEntity.ok(this.orderClientService.update(orderId, orderDTO).getBody());
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("orderId") @Valid String orderId){
        return ResponseEntity.ok(this.orderClientService.deleteById(orderId).getBody());
    }
}
