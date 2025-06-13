package HappyProject.Proxy_Client.Bussiness.User.Service;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.AddressDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.AddressUseServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserService", contextId = "addressClientService", url = "http://localhost:9050/UserService/api/address")
public interface AddressClientService {

    @GetMapping
    ResponseEntity<AddressUseServiceResponse> findAll();

    @GetMapping("/{addressId}")
    ResponseEntity<AddressDTO> findById(@PathVariable("addressId") @NotBlank(message = "Input is not blank") @Valid String addressId);

    @PostMapping
    ResponseEntity<AddressDTO> save(@RequestBody @NotNull(message = "Input must not null") @Valid AddressDTO addressDTO);

    @PutMapping
    ResponseEntity<AddressDTO> update(@RequestBody @PathVariable("addressId") @NotNull(message = "Input must not null") @Valid AddressDTO addressDTO);

    @PutMapping("/{addressId}")
    ResponseEntity<AddressDTO> update(@RequestBody @PathVariable("addressId") @NotNull(message = "Input must not null") @Valid String addressId);

    @DeleteMapping("/{addressId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("addressId") @NotBlank(message = "Input must not blank") @Valid final String addressId);
}
