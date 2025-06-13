package HappyProject.Product_Service.Service;

import HappyProject.Product_Service.Model.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(final Integer productId);
    ProductDTO save(final ProductDTO productDTO);
    ProductDTO update(final ProductDTO productDTO);
    ProductDTO update(final ProductDTO productDTO, final Integer productId);
    void deleteById(final Integer productId);
}
