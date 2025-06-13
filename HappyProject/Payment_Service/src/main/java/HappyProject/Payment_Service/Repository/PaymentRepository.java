package HappyProject.Payment_Service.Repository;

import HappyProject.Payment_Service.Model.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
