package HappyProject.Order_Service.Controller;

import HappyProject.Order_Service.Model.DTO.CartDTO;
import HappyProject.Order_Service.Model.Response.ResponseDTOCollection;
import HappyProject.Order_Service.Service.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDTO> save(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO) {
        log.info("CartDTO, Save the cart");
        return ResponseEntity.ok(this.cartService.save(cartDTO));
    }

    @PutMapping
    public  ResponseEntity<CartDTO> update(@RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO) {
        log.info("CartDTO, Update the cart");
        return ResponseEntity.ok(this.cartService.save(cartDTO));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<CartDTO> update(@PathVariable("orderId") @NotBlank(message = "Input must be not null") @Valid String cartId, @RequestBody @NotNull(message = "Input must be not null") @Valid CartDTO cartDTO) {
        log.info("CartDTO, Update the cart with id");
        return ResponseEntity.ok(this.cartService.update(Integer.parseInt(cartId),cartDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseDTOCollection<CartDTO>> findAll() {
        log.info("CartDTO, find all cart");
        return ResponseEntity.ok(new ResponseDTOCollection<>(this.cartService.findAll()));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<CartDTO> findById(@PathVariable("orderId") @NotBlank(message = "Input must be not null") @Valid String cartId) {
        log.info("CartDTO, Retrieve the cart using the id");
        return ResponseEntity.ok(this.cartService.findById(Integer.parseInt(cartId)));
    }

    @DeleteMapping("/orderId")
    public ResponseEntity<Boolean> delete(@PathVariable("orderId") @NotBlank(message = "Input must be not null") @Valid String cartId) {
        log.info("CartDTO, Delete the cart");
        this.cartService.deleteById(Integer.parseInt(cartId));
        return ResponseEntity.ok(true);
    }
}
