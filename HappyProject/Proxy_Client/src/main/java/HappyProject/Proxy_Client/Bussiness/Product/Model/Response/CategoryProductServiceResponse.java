package HappyProject.Proxy_Client.Bussiness.Product.Model.Response;

import HappyProject.Proxy_Client.Bussiness.Product.Model.DTO.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryProductServiceResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Collection<CategoryDTO> categoryDTOs;
}
