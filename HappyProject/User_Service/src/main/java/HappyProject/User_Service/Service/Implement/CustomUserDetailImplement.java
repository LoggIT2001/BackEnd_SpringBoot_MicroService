package HappyProject.User_Service.Service.Implement;

import HappyProject.User_Service.Exceptions.UserObjectNotFoundException;
import HappyProject.User_Service.Model.Entity.Credential;
import HappyProject.User_Service.Repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserDetailImplement implements UserDetailsService {

    @Autowired
    private final CredentialRepository credentialRepository;

    public CustomUserDetailImplement(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = credentialRepository.findByUserName(username).orElseThrow(() -> new UserObjectNotFoundException("User not found with username: " + username));
        return new User(
                credential.getUserName(),
                credential.getPassword(),
                credential.getIsEnabled(),
                credential.getIsAccountNonExpired(),
                credential.getIsCredentialsNonExpired(),
                credential.getIsAccountNonLocked(),
                Collections.singletonList(new SimpleGrantedAuthority(credential.getRoleBasedAuthority().name()))
        );
    }
}
