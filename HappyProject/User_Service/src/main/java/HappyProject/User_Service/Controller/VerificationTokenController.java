package HappyProject.User_Service.Controller;

import HappyProject.User_Service.Model.DTO.VerificationDTO;
import HappyProject.User_Service.Response.ResponseCollectionDTO;
import HappyProject.User_Service.Service.VerificationTokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/verificationTokens")
public class VerificationTokenController {
    private final VerificationTokenService verificationTokenService;

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<VerificationDTO>> findAll() {
        log.info("*** VerificationTokenDto List, controller; fetch all verificationTokens *");
        return ResponseEntity.ok(new ResponseCollectionDTO<>(this.verificationTokenService.findAll()));
    }

    @GetMapping("/{verificationTokenId}")
    public ResponseEntity<VerificationDTO> findById(@PathVariable("verificationTokenId") @NotBlank(message = "Input must not blank") @Valid final String verificationTokenId) {
        log.info("*** VerificationTokenDto, resource; fetch verificationToken by id *");
        return ResponseEntity.ok(this.verificationTokenService.findById(Integer.parseInt(verificationTokenId.strip())));
    }

    @PostMapping
    public ResponseEntity<VerificationDTO> save(@RequestBody @NotNull(message = "Input must not NULL") @Valid final VerificationDTO verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; save verificationToken *");
        return ResponseEntity.ok(this.verificationTokenService.save(verificationTokenDto));
    }

    @PutMapping
    public ResponseEntity<VerificationDTO> update(@RequestBody @NotNull(message = "Input must not NULL") @Valid final VerificationDTO verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; update verificationToken *");
        return ResponseEntity.ok(this.verificationTokenService.update(verificationTokenDto));
    }

    @PutMapping("/{verificationTokenId}")
    public ResponseEntity<VerificationDTO> update(@PathVariable("verificationTokenId") @NotBlank(message = "Input must not blank") final String verificationTokenId, @RequestBody @NotNull(message = "Input must not NULL") @Valid final VerificationDTO verificationTokenDto) {
        log.info("*** VerificationTokenDto, resource; update verificationToken with verificationTokenId *");
        return ResponseEntity.ok(this.verificationTokenService.update(Integer.parseInt(verificationTokenId.strip()), verificationTokenDto));
    }

    @DeleteMapping("/{verificationTokenId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("verificationTokenId") @NotBlank(message = "Input must not blank") final String verificationTokenId) {
        log.info("*** Boolean, resource; delete verificationToken by id *");
        this.verificationTokenService.deleteById(Integer.parseInt(verificationTokenId));
        return ResponseEntity.ok(true);
    }
}
