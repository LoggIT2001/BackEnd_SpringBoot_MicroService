package HappyProject.User_Service.HelperClass;

import HappyProject.User_Service.Model.DTO.CredentialDTO;
import HappyProject.User_Service.Model.DTO.VerificationDTO;
import HappyProject.User_Service.Model.Entity.Credential;
import HappyProject.User_Service.Model.Entity.VerificationToken;

public interface VerificationTokenMapping {
    public static VerificationDTO map(final VerificationToken verificationToken){
        return VerificationDTO.builder().verificationTokenId(verificationToken.getVerificationTokenId())
                .token(verificationToken.getToken())
                .expireDate(verificationToken.getExpireDate())
                .credentialDTO(
                        CredentialDTO.builder().credentialId(verificationToken.getCredential().getCredentialId())
                                .userName(verificationToken.getCredential().getUserName())
                                .password(verificationToken.getCredential().getPassword())
                                .roleBasedAuthority(verificationToken.getCredential().getRoleBasedAuthority())
                                .isEnabled(verificationToken.getCredential().getIsEnabled())
                                .build())
                .build();
    }

    public static VerificationToken map(final VerificationDTO verificationDTO) {
        return VerificationToken.builder()
                .verificationTokenId(verificationDTO.getVerificationTokenId())
                .token(verificationDTO.getToken())
                .expireDate(verificationDTO.getExpireDate())
                .credential(
                        Credential.builder()
                                .credentialId(verificationDTO.getCredentialDTO().getCredentialId())
                                .userName(verificationDTO.getCredentialDTO().getUserName())
                                .password(verificationDTO.getCredentialDTO().getPassword())
                                .roleBasedAuthority(verificationDTO.getCredentialDTO().getRoleBasedAuthority())
                                .isEnabled(verificationDTO.getCredentialDTO().getIsEnabled())
                                .build())
                .build();
    }
}
