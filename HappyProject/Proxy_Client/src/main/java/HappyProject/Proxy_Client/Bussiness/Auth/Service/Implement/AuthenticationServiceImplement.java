package HappyProject.Proxy_Client.Bussiness.Auth.Service.Implement;

import HappyProject.Proxy_Client.Bussiness.Auth.Model.Request.AuthenticationRequest;
import HappyProject.Proxy_Client.Bussiness.Auth.Model.Response.AuthenticationResponse;
import HappyProject.Proxy_Client.Bussiness.Auth.Service.AuthenticationService;
import HappyProject.Proxy_Client.Exception.IllegalAuthenticationCredentialsException;
import HappyProject.Proxy_Client.Jwt.Service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        log.info("AuthenticationResponse, authenticate use service");
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException exception){
            throw new IllegalAuthenticationCredentialsException("Bad credential");
        }
        return new AuthenticationResponse(this.jwtService.generateToken(this.userDetailsService.loadUserByUsername(authenticationRequest.getUserName())));
    }

    @Override
    public Boolean authenticate(String jwt) {
        return null;
    }
}
