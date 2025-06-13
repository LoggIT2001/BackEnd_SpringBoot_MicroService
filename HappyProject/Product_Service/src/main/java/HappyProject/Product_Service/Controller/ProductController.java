package HappyProject.Product_Service.Controller;

import HappyProject.Product_Service.Model.DTO.ProductDTO;
import HappyProject.Product_Service.Model.Response.DTOCollectionResponse;
import HappyProject.Product_Service.Service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @NotNull(message = "Input must be not null") @Valid final ProductDTO productDTO) {
        log.info("ProductDTo, Controller; save the products");
        return ResponseEntity.ok(this.productService.save(productDTO));
    }

    @GetMapping
    public ResponseEntity<DTOCollectionResponse<ProductDTO>> findAll() {
        log.info("ProductDTO, Controller, fetch all the products");
        return ResponseEntity.ok(new DTOCollectionResponse<>(this.productService.findAll()));
    }

    @GetMapping("/productId")
    public ResponseEntity<ProductDTO> findById(@PathVariable("productId") @RequestBody @NotNull(message = "Input must be not null") @Valid final String productId) {
        return ResponseEntity.ok(this.productService.findById(Integer.parseInt(productId)));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody @NotNull(message = "Input must be not null") @Valid ProductDTO productDTO){
        return ResponseEntity.ok(this.productService.update(productDTO));
    }

    @PutMapping("/productId")
    public ResponseEntity<ProductDTO> update( @PathVariable("productId") @RequestBody @NotNull(message = "Input must be not null") @Valid final String productId, @RequestBody @NotNull(message = "Input must be not null") @Valid ProductDTO productDTO){
        return ResponseEntity.ok(this.productService.update(productDTO, Integer.parseInt(productId)));
    }

    @DeleteMapping("/productId")
    public ResponseEntity<Boolean> deleteById( @PathVariable("productId") final String productId) {
        this.productService.deleteById(Integer.parseInt(productId));
        return ResponseEntity.ok(true);
    }
}
