package HappyProject.Proxy_Client.Bussiness.User.Model.DTO;

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
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String fullName;
    private String imageUrl;
    private String email;
    private String phone;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Set<AddressDTO> addressDTOs;

    @JsonProperty("credential")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private CredentialDTO credentialDTO;
}
