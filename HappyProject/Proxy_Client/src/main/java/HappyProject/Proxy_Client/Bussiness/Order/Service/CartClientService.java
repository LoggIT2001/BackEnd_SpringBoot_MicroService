package HappyProject.Proxy_Client.Bussiness.Order.Service;

import HappyProject.Proxy_Client.Bussiness.Order.Model.DTO.CartDTO;
import HappyProject.Proxy_Client.Bussiness.Order.Model.Response.CartOrderServiceResponse;
import brave.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "OrderService", contextId = "cartClientService", url = "http://localhost:9052/Order_Service/api/carts")
public interface CartClientService {
    @GetMapping
    public ResponseEntity<CartOrderServiceResponse> findAll();

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTO> findById(@PathVariable("cartId") @NotBlank(message = "Input must not be blank") @Valid final String cartId);

    @PostMapping
    public ResponseEntity<CartDTO> save(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO);

    @PutMapping
    public ResponseEntity<CartDTO> update(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO);

    @PutMapping("/{cartId}")
    public ResponseEntity<CartDTO> update(@PathVariable("cartId") @NotBlank(message = "Input must not be blank") @Valid final String cartId, @RequestBody @NotNull(message = "Input must not be null") @Valid CartDTO cartDTO);

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("cartId") final String cartId);
}
