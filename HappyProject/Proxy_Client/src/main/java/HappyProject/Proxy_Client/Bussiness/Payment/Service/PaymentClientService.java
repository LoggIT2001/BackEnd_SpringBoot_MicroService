package HappyProject.Proxy_Client.Bussiness.Payment.Service;

import HappyProject.Proxy_Client.Bussiness.Payment.Model.DTO.PaymentDTO;
import HappyProject.Proxy_Client.Bussiness.Payment.Model.Response.PaymentServiceResponse;
import brave.Response;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Payment_Service", contextId = "paymentClientService", path = "/Payment_Service/api/payments")
public interface PaymentClientService {
    @GetMapping
    public ResponseEntity<PaymentServiceResponse> findAll();

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable("paymentId") @NotBlank @Valid String paymentId);

    @PostMapping
    public ResponseEntity<PaymentDTO> save(@RequestBody @NotNull @Valid PaymentDTO paymentDTO);

    @PutMapping
    public ResponseEntity<PaymentDTO> update(@RequestBody @NotNull @Valid PaymentDTO paymentDTO);

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("paymentId") String paymentId);
}
