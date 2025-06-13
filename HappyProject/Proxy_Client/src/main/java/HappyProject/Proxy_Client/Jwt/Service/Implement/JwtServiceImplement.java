package HappyProject.Proxy_Client.Jwt.Service.Implement;

import HappyProject.Proxy_Client.Jwt.Service.JwtService;
import HappyProject.Proxy_Client.Jwt.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImplement implements JwtService {

    private final JwtUtil jwtUtil;

    @Override
    public String extractUsername(String token) {
        log.info("String, jwt service extract username from given token");
        return this.jwtUtil.extractUserName(token);
    }

    @Override
    public Date extractExpiration(String token) {
        log.info("Date, jwt service extract expiration from given token");
        return this.jwtUtil.extractException(token);
    }

    @Override
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        log.info("T, jwt service extract claims from given token and claimResolver Function");
        return this.jwtUtil.extractClaims(token, claimsResolver);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        log.info("String, jwt service generate token from given userDetails");
        return this.jwtUtil.generateToken(userDetails);
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        log.info("Boolean, jwt service validate token from given token and userDetails");
        return this.jwtUtil.validateToken(token, userDetails);
    }
}
