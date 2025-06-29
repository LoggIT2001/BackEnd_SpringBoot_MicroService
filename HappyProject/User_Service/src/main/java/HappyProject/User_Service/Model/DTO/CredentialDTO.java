package HappyProject.User_Service.Model.DTO;

import HappyProject.User_Service.Model.Enums.RoleBasedAuthority;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer credentialId;
    private String userName;
    private String password;
    private RoleBasedAuthority roleBasedAuthority;
    private Boolean isEnabled;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialNonExpired;

    @JsonProperty("user")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private UserDTO userDTO;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Set<VerificationDTO> verificationDTOs;
}
