package HappyProject.Proxy_Client.Bussiness.Auth.Service;

import HappyProject.Proxy_Client.Bussiness.Auth.Model.Request.AuthenticationRequest;
import HappyProject.Proxy_Client.Bussiness.Auth.Model.Response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest);
    Boolean authenticate(final String jwt);
}
