package HappyProject.Proxy_Client.Bussiness.User.Controller;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.VerificationDTO;
import HappyProject.Proxy_Client.Bussiness.User.Service.VerificationTokenClientService;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.VerificationTokenUseServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/verifications")
public class VerificationController {
    private final VerificationTokenClientService verificationTokenClientService;

    @GetMapping
    public ResponseEntity<VerificationTokenUseServiceResponse> findAll() {
        return ResponseEntity.ok(this.verificationTokenClientService.findAll().getBody());
    }

    @GetMapping("/{verificationTokenId}")
    public ResponseEntity<VerificationDTO> findById(@PathVariable("verificationTokenId") final String verificationTokenId) {
        return ResponseEntity.ok(this.verificationTokenClientService.findById(verificationTokenId).getBody());
    }

    @PostMapping
    public ResponseEntity<VerificationDTO> save(@RequestBody final VerificationDTO verificationTokenDto) {
        return ResponseEntity.ok(this.verificationTokenClientService.save(verificationTokenDto).getBody());
    }

    @PutMapping
    public ResponseEntity<VerificationDTO> update(@RequestBody final VerificationDTO verificationTokenDto) {
        return ResponseEntity.ok(this.verificationTokenClientService.update(verificationTokenDto).getBody());
    }

    @PutMapping("/{verificationTokenId}")
    public ResponseEntity<VerificationDTO> update(@PathVariable("verificationTokenId") final String verificationTokenId, @RequestBody final VerificationDTO verificationTokenDto) {
        return ResponseEntity.ok(this.verificationTokenClientService.update(verificationTokenDto).getBody());
    }

    @DeleteMapping("/{verificationTokenId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("verificationTokenId") final String verificationTokenId) {
        return ResponseEntity.ok(this.verificationTokenClientService.deleteById(verificationTokenId).getBody());
    }

}
