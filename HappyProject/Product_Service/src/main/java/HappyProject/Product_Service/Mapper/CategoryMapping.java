package HappyProject.Product_Service.Mapper;

import HappyProject.Product_Service.Model.DTO.CategoryDTO;
import HappyProject.Product_Service.Model.Entity.Category;

import java.util.Optional;

public interface CategoryMapping {
    public static CategoryDTO map(final Category category){
        final var parentCategory = Optional.ofNullable(category.getParentCatgory()).orElseGet(() -> new Category());
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .parentCategoryDTO(
                        CategoryDTO.builder()
                                .categoryId(parentCategory.getCategoryId())
                                .categoryName(parentCategory.getCategoryName())
                                .build())
                .build();
    }

    public static Category map(final CategoryDTO categoryDTO){
        final var parentCategoryDTO = Optional.ofNullable(categoryDTO.getParentCategoryDTO()).orElseGet(() -> new CategoryDTO());
        return Category.builder()
                .categoryId(categoryDTO.getCategoryId())
                .categoryName(categoryDTO.getCategoryName())
                .parentCatgory(
                    Category.builder()
                            .categoryId(parentCategoryDTO.getCategoryId())
                            .categoryName(parentCategoryDTO.getCategoryName())
                            .build())
                .build();
    }

    public static Category convertToEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

    public static CategoryDTO convertToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }
}
