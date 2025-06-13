package HappyProject.Product_Service.Service.Implement;

import HappyProject.Product_Service.Exception.ProductNotFoundException;
import HappyProject.Product_Service.Mapper.ProductMapping;
import HappyProject.Product_Service.Model.DTO.ProductDTO;
import HappyProject.Product_Service.Repository.ProductRepository;
import HappyProject.Product_Service.Service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductImplement implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        log.info("ProductDTO, find all product");
        return this.productRepository.findAll().stream().map(ProductMapping::map).distinct().collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Integer productId) {
        log.info("ProductDTO, find product by id");
        return this.productRepository.findById(productId).map(ProductMapping::map).orElseThrow(() -> new ProductNotFoundException(String.format("Product with id %d not found", productId)));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        log.info("ProductDTO, save the product");
        return ProductMapping.map(this.productRepository.save(ProductMapping.map(productDTO)));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        log.info("ProductDTO, update the product");
        return ProductMapping.map(this.productRepository.save(ProductMapping.map(productDTO)));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Integer productId) {
        log.info("ProductDTO, update the product by id");
        return ProductMapping.map(this.productRepository.save(ProductMapping.map(this.findById(productId))));
    }

    @Override
    public void deleteById(Integer productId) {
        log.info("ProductDTO, delete product by id");
        this.productRepository.deleteById(productId);
    }
}
