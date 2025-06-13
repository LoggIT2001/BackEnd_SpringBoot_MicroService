package HappyProject.Proxy_Client.Bussiness.User.Service;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.VerificationDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.VerificationTokenUseServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserService", contextId = "verificationTokenClientService", url = "http://localhost:9050/UserService/api/verificationTokens")
public interface VerificationTokenClientService {
    @GetMapping
    ResponseEntity<VerificationTokenUseServiceResponse> findAll();

    @GetMapping("/{verificationTokenId}")
    ResponseEntity<VerificationDTO> findById(@PathVariable("verificationTokenId") @NotBlank(message = "*Input must not blank!**") @Valid final String verificationTokenId);

    @PostMapping
    ResponseEntity<VerificationDTO> save(@RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final VerificationDTO verificationTokenDto);

    @PutMapping
    ResponseEntity<VerificationDTO> update(@RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final VerificationDTO verificationTokenDto);

    @PutMapping("/{verificationTokenId}")
    ResponseEntity<VerificationDTO> update(@PathVariable("verificationTokenId") @NotBlank(message = "*Input must not blank!**") final String verificationTokenId, @RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final VerificationDTO verificationTokenDto);

    @DeleteMapping("/{verificationTokenId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("verificationTokenId") @NotBlank(message = "*Input must not blank!**") @Valid final String verificationTokenId);

}
