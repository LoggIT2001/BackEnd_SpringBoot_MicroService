package HappyProject.Proxy_Client.Bussiness.OrderItem.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer OrderId;
    private Integer orderedQuantity;

    @JsonProperty("product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductDTO productDTO;

    @JsonProperty("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderDTO orderDTO;
}
