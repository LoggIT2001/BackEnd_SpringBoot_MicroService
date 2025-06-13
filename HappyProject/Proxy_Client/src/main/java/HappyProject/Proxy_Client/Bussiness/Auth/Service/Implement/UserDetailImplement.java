package HappyProject.Proxy_Client.Bussiness.Auth.Service.Implement;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.CredentialDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.UserDetailsImplement;
import HappyProject.Proxy_Client.Constant.AppConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailImplement implements UserDetailsService {
    private static final String API_URL = AppConstant.DiscoveredDomainsAPI.USER_SERVICE_HOST + "/api/credential";
    private final RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetails, load user by userName");
        return new UserDetailsImplement(this.restTemplate.getForObject(API_URL + "/username" + username, CredentialDTO.class));
    }
}
