package HappyProject.Proxy_Client.Bussiness.Product.Controller;

import HappyProject.Proxy_Client.Bussiness.Product.Model.DTO.CategoryDTO;
import HappyProject.Proxy_Client.Bussiness.Product.Model.Response.CategoryProductServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Product.Service.CategoryClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private final CategoryClientService categoryClientService;

    @GetMapping
    public ResponseEntity<CategoryProductServiceResponse> findAll(){
        return ResponseEntity.ok(this.categoryClientService.findAll().getBody());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("categoryId") final String categoryId){
        return ResponseEntity.ok(this.categoryClientService.findById(categoryId).getBody());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody final CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryClientService.save(categoryDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestBody final CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryClientService.update(categoryDTO).getBody());
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("categoryId") final String categoryId, @RequestBody final CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryClientService.update(categoryId, categoryDTO).getBody());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Boolean> delete(@PathVariable("categoryId") final String categoryId){
        return ResponseEntity.ok(this.categoryClientService.deleteById(categoryId).getBody());
    }
}
