package HappyProject.Proxy_Client.Bussiness.User.Model;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.CredentialDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class UserDetailsImplement implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final CredentialDTO credentialDTO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.credentialDTO.getRoleBasedAuthority().name()));
    }

    @Override
    public String getPassword() {
        return this.credentialDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return this.credentialDTO.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
