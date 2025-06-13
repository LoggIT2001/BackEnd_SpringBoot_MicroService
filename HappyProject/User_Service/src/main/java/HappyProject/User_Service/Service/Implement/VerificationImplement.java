package HappyProject.User_Service.Service.Implement;

import HappyProject.User_Service.Exceptions.VerificationTokenNotFoundException;
import HappyProject.User_Service.HelperClass.VerificationTokenMapping;
import HappyProject.User_Service.Model.DTO.VerificationDTO;
import HappyProject.User_Service.Repository.VerificationTokenRepository;
import HappyProject.User_Service.Service.VerificationTokenService;
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
public class VerificationImplement implements VerificationTokenService {

    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    public VerificationImplement(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public List<VerificationDTO> findAll() {
        log.info("Find all the verification Token");
        return this.verificationTokenRepository.findAll().stream().map(VerificationTokenMapping::map).distinct().collect(Collectors.toList());
    }

    @Override
    public VerificationDTO findById(Integer verificationTokenId) {
        log.info("Find verification by Id");
        return this.verificationTokenRepository.findById(verificationTokenId).map(VerificationTokenMapping::map).orElseThrow(() -> new VerificationTokenNotFoundException(String.format("Verification Token with id: %d not found",verificationTokenId)));
    }

    @Override
    public VerificationDTO save(VerificationDTO verificationDTO) {
        log.info("save the verification Token");
        return VerificationTokenMapping.map(this.verificationTokenRepository.save(VerificationTokenMapping.map(verificationDTO)));
    }

    @Override
    public VerificationDTO update(VerificationDTO verificationDTO) {
        log.info("update the verification Token");
        return VerificationTokenMapping.map(this.verificationTokenRepository.save(VerificationTokenMapping.map(verificationDTO)));
    }

    @Override
    public VerificationDTO update(Integer verificationTokenId, VerificationDTO verificationDTO) {
        log.info("update the verification Token");
        return VerificationTokenMapping.map(this.verificationTokenRepository.save(VerificationTokenMapping.map(this.findById(verificationTokenId))));
    }

    @Override
    public void deleteById(Integer verificationTokenId) {
        log.info("Delete verification by Id");
        this.verificationTokenRepository.deleteById(verificationTokenId);
    }
}
