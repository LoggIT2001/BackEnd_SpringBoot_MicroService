package HappyProject.Proxy_Client.Bussiness.Auth.Controller;

import HappyProject.Proxy_Client.Bussiness.Auth.Model.Request.AuthenticationRequest;
import HappyProject.Proxy_Client.Bussiness.Auth.Model.Response.AuthenticationResponse;
import HappyProject.Proxy_Client.Bussiness.Auth.Service.AuthenticationService;
import brave.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/authenticate")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @NotNull(message = "Input must not be null") @Valid final AuthenticationRequest authenticationRequest){
        log.info("Authenticate Controller, proceed with the request");
        return ResponseEntity.ok(this.authenticationService.authenticate(authenticationRequest));
    }

    @GetMapping("/jwt/{jwt}")
    public ResponseEntity<Boolean> authenticate(@PathVariable("jwt") final String jwt){
        log.info("Authentication controller, proceed with the request");
        return ResponseEntity.ok(this.authenticationService.authenticate(jwt));
    }
}
