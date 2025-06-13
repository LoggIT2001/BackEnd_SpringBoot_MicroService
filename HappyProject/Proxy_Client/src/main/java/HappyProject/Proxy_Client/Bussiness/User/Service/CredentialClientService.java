package HappyProject.Proxy_Client.Bussiness.User.Service;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.CredentialDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.CredentialUseServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserService", contextId = "credentialClientService", url = "http://localhost:9050/UserService/api/credentials")
public interface CredentialClientService {

    @GetMapping
    ResponseEntity<CredentialUseServiceResponse> findAll();

    @GetMapping("/{credentialId}")
    ResponseEntity<CredentialDTO> findById(@PathVariable("credentialId") @NotBlank(message = "Input must not be blank") @Valid final String credentialId);

    @PostMapping
    ResponseEntity<CredentialDTO> save(@RequestBody @NotNull(message = "input must not be blank") @Valid final CredentialDTO credentialDTO);

    @PutMapping
    ResponseEntity<CredentialDTO> update( @RequestBody @NotNull(message = "Input must not NULL") @Valid final CredentialDTO credentialDto);

    @PutMapping("/{credentialId}")
    ResponseEntity<CredentialDTO> update(@PathVariable("credentialId") @NotBlank(message = "Input must not blank") final String credentialId, @RequestBody @NotNull(message = "Input must not NULL") @Valid final CredentialDTO credentialDto);

    @DeleteMapping("/{credentialId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("credentialId") @NotBlank(message = "Input must not blank") @Valid final String credentialId);

    @GetMapping("/username/{username}")
    ResponseEntity<CredentialDTO> findByUserName(@PathVariable("username") final String username);
}
