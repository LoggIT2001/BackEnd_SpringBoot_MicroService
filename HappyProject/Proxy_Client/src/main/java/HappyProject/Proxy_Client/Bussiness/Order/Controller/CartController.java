package HappyProject.Proxy_Client.Bussiness.Order.Controller;

import HappyProject.Proxy_Client.Bussiness.Order.Model.DTO.CartDTO;
import HappyProject.Proxy_Client.Bussiness.Order.Model.Response.CartOrderServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Order.Service.CartClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {
    private final CartClientService cartClientService;

    @GetMapping
    public ResponseEntity<CartOrderServiceResponse> findAll(){
        return ResponseEntity.ok(this.cartClientService.findAll().getBody());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTO> findById(@PathVariable("cartId") @NotBlank(message = "Input must not be blank") @Valid final String cartId){
        return ResponseEntity.ok(this.cartClientService.findById(cartId).getBody());
    }

    @PostMapping
    public ResponseEntity<CartDTO> save(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO){
        return ResponseEntity.ok(this.cartClientService.save(cartDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<CartDTO> update(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO){
        return ResponseEntity.ok(this.cartClientService.update(cartDTO).getBody());
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartDTO> update(@PathVariable("cartId") @NotBlank(message = "Input must not be blank") @Valid final String cartId, @RequestBody @NotNull(message = "Input must not be null") @Valid CartDTO cartDTO){
        return ResponseEntity.ok(this.cartClientService.update(cartId, cartDTO).getBody());
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("cartId") final String cartId){
        return ResponseEntity.ok(this.cartClientService.deleteById(cartId).getBody());
    }
}
