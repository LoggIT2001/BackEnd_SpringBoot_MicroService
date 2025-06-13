package HappyProject.Proxy_Client.Bussiness.User.Service;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.UserDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.UserCollectionUseServiceResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserService", contextId = "userClientService", url = "http://localhost:9050/UserService/api/users")
public interface UserClientService {
    @GetMapping
    ResponseEntity<UserCollectionUseServiceResponse> findAll();

    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> findById(@PathVariable("userId") @NotBlank(message = "*Input must not blank!**") @Valid final String userId);

    @GetMapping("/username/{username}")
    ResponseEntity<UserDTO> findByUsername(@PathVariable("username") @NotBlank(message = "*Input must not blank!**") @Valid final String username);

    @PostMapping
    ResponseEntity<UserDTO> save(@RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final UserDTO userDto);

    @PutMapping
    ResponseEntity<UserDTO> update(@RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final UserDTO userDto);

    @PutMapping("/{userId}")
    ResponseEntity<UserDTO> update(@PathVariable("userId") @NotBlank(message = "*Input must not blank!**") final String userId, @RequestBody @NotNull(message = "*Input must not NULL!**") @Valid final UserDTO userDto);

    @DeleteMapping("/{userId}")
    ResponseEntity<Boolean> deleteById(@PathVariable("userId") @NotBlank(message = "*Input must not blank!**") @Valid final String userId);
}
