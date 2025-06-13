package HappyProject.Proxy_Client.Bussiness.User.Controller;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.UserDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.UserCollectionUseServiceResponse;
import HappyProject.Proxy_Client.Bussiness.User.Service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserClientService userClientService;

    @GetMapping
    public ResponseEntity<UserCollectionUseServiceResponse> findAll() {
        return ResponseEntity.ok(this.userClientService.findAll().getBody());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable("userId") final String userId) {
        return ResponseEntity.ok(this.userClientService.findById(userId).getBody());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable("username") final String username) {
        return ResponseEntity.ok(this.userClientService.findByUsername(username).getBody());
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody final UserDTO userDto) {
        return ResponseEntity.ok(this.userClientService.save(userDto).getBody());
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody final UserDTO userDto) {
        return ResponseEntity.ok(this.userClientService.update(userDto).getBody());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> update(@PathVariable("userId") final String userId, @RequestBody final UserDTO userDto) {
        return ResponseEntity.ok(this.userClientService.update(userDto).getBody());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("userId") final String userId) {
        return ResponseEntity.ok(this.userClientService.deleteById(userId).getBody());
    }
}
