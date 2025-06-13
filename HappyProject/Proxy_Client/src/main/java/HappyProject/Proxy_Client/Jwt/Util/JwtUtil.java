package HappyProject.Proxy_Client.Jwt.Util;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtUtil {

    String extractUserName(final String token);
    Date extractException(final String token);
    <T> T extractClaims(final String token, final Function<Claims, T> claimsResolver);
    String generateToken(final UserDetails userDetails);
    Boolean validateToken(final String token, final UserDetails userDetails);
}
