package HappyProject.Product_Service.Service;

import HappyProject.Product_Service.Model.DTO.CategoryDTO;
import HappyProject.Product_Service.Model.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(final Integer categoryId);
    CategoryDTO save(final CategoryDTO categoryDTO);
    CategoryDTO update(final CategoryDTO categoryDTO);
    CategoryDTO update(final Integer categoryId, final CategoryDTO categoryDTO);
    void deleteById(final Integer categoryId);
}
