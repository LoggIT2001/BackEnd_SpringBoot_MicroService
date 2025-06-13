package HappyProject.User_Service.Service;

import HappyProject.User_Service.Model.DTO.VerificationDTO;

import java.util.List;

public interface VerificationTokenService {
    List<VerificationDTO> findAll();
    VerificationDTO findById(final Integer verificationTokenId);
    VerificationDTO save(final VerificationDTO verificationDTO);
    VerificationDTO update(final VerificationDTO verificationDTO);
    VerificationDTO update(final Integer verificationTokenId, final VerificationDTO verificationDTO);
    void deleteById(final Integer verificationTokenId);
}
