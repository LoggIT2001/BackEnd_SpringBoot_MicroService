package HappyProject.Proxy_Client.Bussiness.Auth.Model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String jwtToken;
}
