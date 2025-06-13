package HappyProject.User_Service.Repository;

import HappyProject.User_Service.Model.Entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
    Optional<Credential> findByUserName(final String userName);
}
