package HappyProject.Product_Service.Controller;

import HappyProject.Product_Service.Model.DTO.CategoryDTO;
import HappyProject.Product_Service.Model.Response.DTOCollectionResponse;
import HappyProject.Product_Service.Service.CategoryService;
import brave.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody @NotNull(message = "Input must be not null") @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryService.save(categoryDTO));
    }

    @GetMapping
    public ResponseEntity<DTOCollectionResponse<CategoryDTO>> findAll(){
        return ResponseEntity.ok(new DTOCollectionResponse<>(this.categoryService.findAll()));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("categoryId") @NotNull(message = "Input must be not NULL") @Valid final String categoryId){
        return ResponseEntity.ok(this.categoryService.findById(Integer.parseInt(categoryId)));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("categoryId") @NotNull(message = "Input must be not null") @Valid String categoryId, @RequestBody @NotNull(message = "Input must be not null") @Valid CategoryDTO categoryDTO){
        return ResponseEntity.ok(this.categoryService.update(Integer.parseInt(categoryId), categoryDTO));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Boolean> delete(@PathVariable("categoryId") @NotNull(message = "Input must be not null") @Valid String categoryId){
        this.categoryService.deleteById(Integer.parseInt(categoryId));
        return ResponseEntity.ok(true);
    }
}
