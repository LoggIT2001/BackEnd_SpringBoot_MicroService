package HappyProject.User_Service.HelperClass;

import HappyProject.User_Service.Model.DTO.CredentialDTO;
import HappyProject.User_Service.Model.DTO.UserDTO;
import HappyProject.User_Service.Model.Entity.Credential;
import HappyProject.User_Service.Model.Entity.User;

public interface UserMapping {
    public static UserDTO map(final User user){
        return UserDTO.builder().userId(user.getUserId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .imageUrl(user.getImageUrl())
                .credentialDTO(
                        CredentialDTO.builder().credentialId(user.getCredential().getCredentialId())
                                .userName(user.getCredential().getUserName())
                                .password(user.getCredential().getPassword())
                                .roleBasedAuthority(user.getCredential().getRoleBasedAuthority())
                                .isEnabled(user.getCredential().getIsEnabled())
                                .build())
                .build();
    }

    public static User map(final UserDTO userDTO) {
        // Map UserDTO to User entity
        User user = User.builder()
                .userId(userDTO.getUserId())
                .fullName(userDTO.getFullName())
                .imageUrl(userDTO.getImageUrl())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .build();

        // Map CredentialDTO to Credential entity
        CredentialDTO credentialDTO = userDTO.getCredentialDTO();
        Credential credential = Credential.builder()
                .credentialId(credentialDTO.getCredentialId())
                .userName(credentialDTO.getUserName())
                .password(credentialDTO.getPassword())
                .roleBasedAuthority(credentialDTO.getRoleBasedAuthority())
                .isEnabled(credentialDTO.getIsEnabled())
                .user(user) // Associate the User entity with the Credential
                .build();

        // Set the Credential entity to the User
        user.setCredential(credential);

        return user;
    }
}
