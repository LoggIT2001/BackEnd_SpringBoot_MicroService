package HappyProject.Proxy_Client.Bussiness.User.Controller;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.CredentialDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.CredentialUseServiceResponse;
import HappyProject.Proxy_Client.Bussiness.User.Service.CredentialClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/credentials")
public class CredentialController {
    private final CredentialClientService credentialClientService;

    @GetMapping
    public ResponseEntity<CredentialUseServiceResponse> findAll(){
        return ResponseEntity.ok(this.credentialClientService.findAll().getBody());
    }

    @GetMapping("/{credentialId}")
    public ResponseEntity<CredentialDTO> findById(@PathVariable("credentialId") final String credentialId){
        return ResponseEntity.ok(this.credentialClientService.findById(credentialId).getBody());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<CredentialDTO> findByCredentialname(@PathVariable("username") final String username) {
        return ResponseEntity.ok(this.credentialClientService.findByUserName(username).getBody());
    }

    @PostMapping
    public ResponseEntity<CredentialDTO> save(@RequestBody final CredentialDTO credentialDto) {
        return ResponseEntity.ok(this.credentialClientService.save(credentialDto).getBody());
    }

    @PutMapping
    public ResponseEntity<CredentialDTO> update(@RequestBody final CredentialDTO credentialDto) {
        return ResponseEntity.ok(this.credentialClientService.update(credentialDto).getBody());
    }

    @PutMapping("/{credentialId}")
    public ResponseEntity<CredentialDTO> update(@PathVariable("credentialId") final String credentialId, @RequestBody final CredentialDTO credentialDto) {
        return ResponseEntity.ok(this.credentialClientService.update(credentialDto).getBody());
    }

    @DeleteMapping("/{credentialId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("credentialId") final String credentialId) {
        return ResponseEntity.ok(this.credentialClientService.deleteById(credentialId).getBody());
    }
}
