package HappyProject.User_Service.Security;

public interface JwtUtil {
    String generateToken(String subject);
    String extractUserName(String token);
    boolean validateToken(String token, String userName);
}
