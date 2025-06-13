package HappyProject.Proxy_Client.Bussiness.User.Model.Response;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CredentialUseServiceResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Collection<AddressDTO> collection;
}
