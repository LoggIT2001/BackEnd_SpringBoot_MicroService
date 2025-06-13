package HappyProject.User_Service.Repository;

import HappyProject.User_Service.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCredentialUserName(final String userName);
}
