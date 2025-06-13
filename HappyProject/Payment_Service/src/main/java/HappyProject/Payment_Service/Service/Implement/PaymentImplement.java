package HappyProject.Payment_Service.Service.Implement;

import HappyProject.Payment_Service.Constant.AppConstant;
import HappyProject.Payment_Service.Exception.PaymentNotFoundException;
import HappyProject.Payment_Service.Mapper.PaymentMapping;
import HappyProject.Payment_Service.Model.DTO.OrderDTO;
import HappyProject.Payment_Service.Model.DTO.PaymentDTO;
import HappyProject.Payment_Service.Repository.PaymentRepository;
import HappyProject.Payment_Service.Service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PaymentImplement implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<PaymentDTO> findAll() {
        log.info("PaymentDTO, find all payment");
        return this.paymentRepository.findAll().stream().map(PaymentMapping::map).map(p -> {
            p.setOrderDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.ORDER_SERVICE_API_URL + "/" + p.getOrderDTO().getOrderId(), OrderDTO.class));
            return p;
        }).distinct().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public PaymentDTO findById(Integer paymentId) {
        log.info("PaymentDTO, find the payment by id");
        return this.paymentRepository.findById(paymentId).map(PaymentMapping::map).map(p -> {
            p.setOrderDTO(this.restTemplate.getForObject(AppConstant.DiscoveredDomainsAPI.ORDER_SERVICE_API_URL + "/" + p.getOrderDTO().getOrderId(), OrderDTO.class));
            return p;
        }).orElseThrow(() -> new PaymentNotFoundException(String.format("Payment with id %d not found", paymentId)));
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        log.info("PaymentDTO, save the payment");
        return PaymentMapping.map(this.paymentRepository.save(PaymentMapping.map(paymentDTO)));
    }

    @Override
    public PaymentDTO update(PaymentDTO paymentDTO) {
        log.info("PaymentDTO, update the payment");
        return PaymentMapping.map(this.paymentRepository.save(PaymentMapping.map(paymentDTO)));
    }

    @Override
    public void deleteById(Integer paymentId) {
        log.info("PaymentDTO, delete the payment by id");
        this.paymentRepository.deleteById(paymentId);
    }
}
