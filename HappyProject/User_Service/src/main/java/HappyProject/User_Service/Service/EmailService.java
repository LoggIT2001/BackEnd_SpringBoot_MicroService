package HappyProject.User_Service.Service;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
