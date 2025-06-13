package HappyProject.Proxy_Client.Bussiness.Product.Service;

import HappyProject.Proxy_Client.Bussiness.Product.Model.DTO.ProductDTO;
import HappyProject.Proxy_Client.Bussiness.Product.Model.Response.ProductCollectionProductServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ProductService", contextId = "productClientService", path = "/ProductService/api/products")
public interface ProductClientService {
    @GetMapping
    ResponseEntity<ProductCollectionProductServiceResponse> findAll();

    @GetMapping("/{productId}")
    ResponseEntity<ProductDTO> findById(@PathVariable("productId") @NotBlank(message = "Input must not be blank!") @Valid final String productId);

    @PostMapping
    ResponseEntity<ProductDTO> save(@RequestBody @NotNull(message = "Input must not be NULL!") @Valid final ProductDTO productDto);

    @PutMapping
    ResponseEntity<ProductDTO> update(@RequestBody @NotNull(message = "Input must not be NULL!") @Valid final ProductDTO productDto);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDTO> update(@PathVariable("productId") @NotBlank(message = "Input must not be blank!") @Valid final String productId, @RequestBody @NotNull(message = "Input must not be NULL!") @Valid final ProductDTO productDto);

    @DeleteMapping("/{productId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("productId") final String productId);
}
