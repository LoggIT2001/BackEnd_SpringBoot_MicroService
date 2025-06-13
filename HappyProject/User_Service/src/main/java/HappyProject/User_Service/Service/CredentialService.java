package HappyProject.User_Service.Service;

import HappyProject.User_Service.Model.DTO.CredentialDTO;

import java.util.List;

public interface CredentialService {
    List<CredentialDTO> findAll();
    CredentialDTO findById(final Integer credentialId);
    CredentialDTO save(final CredentialDTO credentialDTO);
    CredentialDTO update(final CredentialDTO credentialDTO);
    CredentialDTO update(final Integer credentialId, final CredentialDTO credentialDTO);
    CredentialDTO findByUserName(final String userName);
    void deleteById(final Integer credentialId);
}
