package HappyProject.Product_Service.Service.Implement;

import HappyProject.Product_Service.Exception.CategoryNotFoundException;
import HappyProject.Product_Service.Mapper.CategoryMapping;
import HappyProject.Product_Service.Model.DTO.CategoryDTO;
import HappyProject.Product_Service.Model.Entity.Category;
import HappyProject.Product_Service.Repository.CategoryRepository;
import HappyProject.Product_Service.Service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CategoryImplement implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryImplement(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAll() {
        log.info("CategoryDTO, find all category");
        return this.categoryRepository.findAll().stream().map(CategoryMapping::map).distinct().collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Integer categoryId) {
        log.info("CategoryDTO, find the category by Id");
        return this.categoryRepository.findById(categoryId).map(CategoryMapping::map).orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id %d is not found", categoryId)));
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        log.info("CategoryDTO, save the category");
        Category category = CategoryMapping.convertToEntity(categoryDTO);

        if(categoryDTO.getParentCategoryDTO() != null && categoryDTO.getParentCategoryDTO().getCategoryId() != null){
            Category parentCategory = categoryRepository.findById(categoryDTO.getParentCategoryDTO().getCategoryId()).orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParentCatgory(parentCategory);
        }
        Category saveCategory = this.categoryRepository.save(category);
        return CategoryMapping.convertToDTO(saveCategory);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        log.info("CategoryDTO, update the category");
        return CategoryMapping.map(this.categoryRepository.save(CategoryMapping.map(categoryDTO)));
    }

    @Override
    public CategoryDTO update(Integer categoryId, CategoryDTO categoryDTO) {
        log.info("CategoryDTO, update category by Id");
        return CategoryMapping.map(this.categoryRepository.save(CategoryMapping.map(this.findById(categoryId))));
    }

    @Override
    public void deleteById(Integer categoryId) {
        log.info("CategoryDTO, delete category by id");
        this.categoryRepository.deleteById(categoryId);
    }
}
