package HappyProject.Proxy_Client.Bussiness.Product.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer categoryId;
    private String categoryName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<CategoryDTO> categoryDTOs;

    @JsonProperty("parentCategory")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CategoryDTO categoryDTO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<ProductDTO> productDTOs;
}
