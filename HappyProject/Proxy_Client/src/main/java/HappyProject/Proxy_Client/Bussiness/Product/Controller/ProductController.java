package HappyProject.Proxy_Client.Bussiness.Product.Controller;

import HappyProject.Proxy_Client.Bussiness.Product.Model.DTO.ProductDTO;
import HappyProject.Proxy_Client.Bussiness.Product.Model.Response.ProductCollectionProductServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Product.Service.ProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductClientService productClientService;

    @GetMapping
    public ResponseEntity<ProductCollectionProductServiceResponse> findAll(){
        return ResponseEntity.ok(this.productClientService.findAll().getBody());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("productId") final String productId){
        return ResponseEntity.ok(this.productClientService.findById(productId).getBody());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody final ProductDTO productDTO){
        return ResponseEntity.ok(this.productClientService.save(productDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody final ProductDTO productDTO){
        return ResponseEntity.ok(this.productClientService.update(productDTO).getBody());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> update(@PathVariable("productId") final String productId, @RequestBody final ProductDTO productDTO){
        return ResponseEntity.ok(this.productClientService.update(productId, productDTO).getBody());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("productId") final String productId){
        return ResponseEntity.ok(this.productClientService.deleteById(productId).getBody());
    }
}
