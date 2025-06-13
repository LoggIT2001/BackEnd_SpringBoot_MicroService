package HappyProject.Product_Service.Mapper;

import HappyProject.Product_Service.Model.DTO.CategoryDTO;
import HappyProject.Product_Service.Model.DTO.ProductDTO;
import HappyProject.Product_Service.Model.Entity.Category;
import HappyProject.Product_Service.Model.Entity.Product;

public interface ProductMapping {
    public static ProductDTO map(final Product product){
        return ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productImageUrl(product.getProductImageUrl())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .categoryDTO(
                      CategoryDTO.builder()
                              .categoryId(product.getCategory().getCategoryId())
                              .categoryName(product.getCategory().getCategoryName())
                              .build())
                .build();
    }

    public static Product map(final ProductDTO productDTO){
        return Product.builder()
                .productId(productDTO.getProductId())
                .productName(productDTO.getProductName())
                .productImageUrl(productDTO.getProductImageUrl())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .category(Category.builder()
                        .categoryId(productDTO.getCategoryDTO().getCategoryId())
                        .categoryName(productDTO.getCategoryDTO().getCategoryName())
                        .build())
                .build();
    }
}
