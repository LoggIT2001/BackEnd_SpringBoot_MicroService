package HappyProject.Payment_Service.Mapper;

import HappyProject.Payment_Service.Model.DTO.OrderDTO;
import HappyProject.Payment_Service.Model.DTO.PaymentDTO;
import HappyProject.Payment_Service.Model.Entity.Payment;

public interface PaymentMapping {
    public static PaymentDTO map(final Payment payment){
        return PaymentDTO.builder()
                .paymentId(payment.getPaymentId())
                .isPayed(payment.isPayed())
                .paymentStatus(payment.getPaymentStatus())
                .orderDTO(OrderDTO.builder()
                        .orderId(payment.getOrderId())
                        .build())
                .build();
    }

    public static Payment map(final PaymentDTO paymentDTO){
        return Payment.builder()
                .paymentId(paymentDTO.getPaymentId())
                .isPayed(paymentDTO.getIsPayed())
                .paymentStatus(paymentDTO.getPaymentStatus())
                .orderId(paymentDTO.getOrderDTO().getOrderId())
                .build();
    }
}
