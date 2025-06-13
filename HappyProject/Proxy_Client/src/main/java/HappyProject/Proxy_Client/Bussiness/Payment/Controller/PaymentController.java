package HappyProject.Proxy_Client.Bussiness.Payment.Controller;

import HappyProject.Proxy_Client.Bussiness.Payment.Model.DTO.PaymentDTO;
import HappyProject.Proxy_Client.Bussiness.Payment.Model.Response.PaymentServiceResponse;
import HappyProject.Proxy_Client.Bussiness.Payment.Service.PaymentClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentClientService paymentClientService;

    @GetMapping
    public ResponseEntity<PaymentServiceResponse> findAll(){
        return ResponseEntity.ok(this.paymentClientService.findAll().getBody());
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable("paymentId") @NotBlank @Valid String paymentId){
        return ResponseEntity.ok(this.paymentClientService.findById(paymentId).getBody());
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> save(@RequestBody @NotNull @Valid PaymentDTO paymentDTO){
        return ResponseEntity.ok(this.paymentClientService.save(paymentDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> update(@RequestBody @NotNull @Valid PaymentDTO paymentDTO){
        return ResponseEntity.ok(this.paymentClientService.update(paymentDTO).getBody());
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("paymentId") String paymentId){
        return ResponseEntity.ok(this.paymentClientService.deleteById(paymentId).getBody());
    }
}
