package HappyProject.Order_Service.Repository;

import HappyProject.Order_Service.Model.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
