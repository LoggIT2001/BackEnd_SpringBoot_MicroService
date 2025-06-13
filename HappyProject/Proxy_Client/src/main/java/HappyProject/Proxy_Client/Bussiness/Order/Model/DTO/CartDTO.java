package HappyProject.Proxy_Client.Bussiness.Order.Model.DTO;

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
public class CartDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer cartId;
    private Integer userId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<OrderDTO> orderDTOs;

    @JsonProperty("user")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDTO userDTO;
}
