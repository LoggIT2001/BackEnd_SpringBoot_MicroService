package HappyProject.User_Service.Service.Implement;

import HappyProject.User_Service.Exceptions.CredentialNotFoundException;
import HappyProject.User_Service.Exceptions.UserObjectNotFoundException;
import HappyProject.User_Service.HelperClass.CredentialMapping;
import HappyProject.User_Service.Model.DTO.CredentialDTO;
import HappyProject.User_Service.Repository.CredentialRepository;
import HappyProject.User_Service.Repository.UserRepository;
import HappyProject.User_Service.Service.CredentialService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CredentialImplement implements CredentialService {

    private CredentialRepository credentialRepository;
    private UserRepository userRepository;

    @Autowired
    public CredentialImplement(CredentialRepository credentialRepository, UserRepository userRepository) {
        this.credentialRepository = credentialRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CredentialDTO> findAll() {
        log.info("CredentialDTO find all the credential");
        return this.credentialRepository.findAll().stream().map(CredentialMapping::map).distinct().collect(Collectors.toList());
    }

    @Override
    public CredentialDTO findById(Integer credentialId) {
        log.info("CredentialDTO find the credential by id");
        return this.credentialRepository.findById(credentialId).map(CredentialMapping::map).orElseThrow(() -> new CredentialNotFoundException(String.format("Credentials not found of this %d",credentialId)));
    }

    @Override
    public CredentialDTO save(CredentialDTO credentialDTO) {
        log.info("CredentialDTO save the credential");
        return CredentialMapping.map(this.credentialRepository.save(CredentialMapping.map(credentialDTO)));
    }

    @Override
    public CredentialDTO update(CredentialDTO credentialDTO) {
        log.info("CredentialDTO update the credential");
        return CredentialMapping.map(this.credentialRepository.save(CredentialMapping.map(credentialDTO)));
    }

    @Override
    public CredentialDTO update(Integer credentialId, CredentialDTO credentialDTO) {
        log.info("CredentialDTO update the credential by id");
        return CredentialMapping.map(this.credentialRepository.save(CredentialMapping.map(this.findById(credentialId))));
    }

    @Override
    public CredentialDTO findByUserName(String userName) {
        log.info("CredentialDTO find the credential by using userName");
        return CredentialMapping.map(this.credentialRepository.findByUserName(userName).orElseThrow(() -> new UserObjectNotFoundException(String.format("Credential with username: %s not found!", userName))));
    }

    @Override
    public void deleteById(Integer credentialId) {
        log.info("CredentialDTO delete the credential");
        this.credentialRepository.deleteById(credentialId);
    }
}
