package HappyProject.User_Service.HelperClass;

import HappyProject.User_Service.Model.DTO.CredentialDTO;
import HappyProject.User_Service.Model.DTO.UserDTO;
import HappyProject.User_Service.Model.Entity.Credential;
import HappyProject.User_Service.Model.Entity.User;

public interface CredentialMapping {
    public static CredentialDTO map(final Credential credential){
        return CredentialDTO.builder().credentialId(credential.getCredentialId())
                .userName(credential.getUserName())
                .password(credential.getPassword())
                .roleBasedAuthority(credential.getRoleBasedAuthority())
                .isEnabled(credential.getIsEnabled())
                .userDTO(
                        UserDTO.builder().userId(credential.getUser().getUserId())
                                .fullName(credential.getUser().getFullName())
                                .email(credential.getUser().getEmail())
                                .phone(credential.getUser().getPhone())
                                .imageUrl(credential.getUser().getImageUrl())
                                .build())
                .build();
    }

    public static Credential map(final CredentialDTO credentialDTO) {
        return Credential.builder().credentialId(credentialDTO.getCredentialId())
                .userName(credentialDTO.getUserName())
                .password(credentialDTO.getPassword())
                .roleBasedAuthority(credentialDTO.getRoleBasedAuthority())
                .isEnabled(credentialDTO.getIsEnabled())
                .user(
                        User.builder()
                                .userId(credentialDTO.getUserDTO().getUserId())
                                .fullName(credentialDTO.getUserDTO().getFullName())
                                .imageUrl(credentialDTO.getUserDTO().getImageUrl())
                                .email(credentialDTO.getUserDTO().getEmail())
                                .phone(credentialDTO.getUserDTO().getPhone())
                                .build())
                .build();
    }
}
