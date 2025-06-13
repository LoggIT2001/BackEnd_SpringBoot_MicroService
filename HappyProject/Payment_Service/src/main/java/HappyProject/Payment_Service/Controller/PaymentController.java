package HappyProject.Payment_Service.Controller;

import HappyProject.Payment_Service.Model.DTO.PaymentDTO;
import HappyProject.Payment_Service.Model.Response.DTOCollectionResponse;
import HappyProject.Payment_Service.Service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<DTOCollectionResponse<PaymentDTO>> findAll(){
        log.info("PaymentDTO controller find all payment");
        return ResponseEntity.ok(new DTOCollectionResponse<>(this.paymentService.findAll()));
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable("paymentId") @NotBlank(message = "Input must not be blank") @Valid final String paymentId){
        log.info("PaymentDTO controller find the payment by id");
        return ResponseEntity.ok(this.paymentService.findById(Integer.parseInt(paymentId)));
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> save(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final PaymentDTO paymentDTO){
        log.info("PaymentDTO controller save the payment");
        return ResponseEntity.ok(this.paymentService.save(paymentDTO));
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> update(@RequestBody @NotNull(message = "Input must not be NULL") @Valid final PaymentDTO paymentDTO){
        log.info("PaymentDTO controller update the payment");
        return ResponseEntity.ok(this.paymentService.update(paymentDTO));
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("paymentId") final String paymentId){
        log.info("PaymentDTO controller delete the payment by id");
        this.paymentService.deleteById(Integer.parseInt(paymentId));
        return ResponseEntity.ok(true);
    }
}
