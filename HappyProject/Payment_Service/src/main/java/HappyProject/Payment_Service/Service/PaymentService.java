package HappyProject.Payment_Service.Service;

import HappyProject.Payment_Service.Model.DTO.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> findAll();
    PaymentDTO findById(Integer paymentId);
    PaymentDTO save(PaymentDTO paymentDTO);
    PaymentDTO update(PaymentDTO paymentDTO);
    void deleteById(Integer paymentId);
}
