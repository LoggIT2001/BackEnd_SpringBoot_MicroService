package HappyProject.User_Service.Service.Implement;

import HappyProject.User_Service.Exceptions.UserObjectNotFoundException;
import HappyProject.User_Service.HelperClass.UserMapping;
import HappyProject.User_Service.Model.DTO.UserDTO;
import HappyProject.User_Service.Model.Entity.User;
import HappyProject.User_Service.Repository.CredentialRepository;
import HappyProject.User_Service.Repository.UserRepository;
import HappyProject.User_Service.Security.JwtUtil;
import HappyProject.User_Service.Service.EmailService;
import HappyProject.User_Service.Service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserImplement implements UserService {

    private UserRepository userRepository;
    private CredentialRepository credentialRepository;
    private EmailService emailService;
    private JwtUtil jwtUtil;

    @Autowired
    public UserImplement(UserRepository userRepository, CredentialRepository credentialRepository, EmailService emailService, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.credentialRepository = credentialRepository;
        this.emailService = emailService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public List<UserDTO> findAll() {
        log.info("find all user");
        return this.userRepository.findAll().stream().map(UserMapping::map).distinct().collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Integer userId) {
        log.info("find user by id");
        return this.userRepository.findById(userId).map(UserMapping::map).orElseThrow(() -> new UserObjectNotFoundException(String.format("User not found with is id: %d",userId)));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.info("save the user");
        return UserMapping.map(this.userRepository.save(UserMapping.map(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        log.info("update the user");
        return UserMapping.map(this.userRepository.save(UserMapping.map(userDTO)));
    }

    @Override
    public UserDTO update(Integer userId, UserDTO userDTO) {
        log.info("update the user by id");
        return UserMapping.map(this.userRepository.save(UserMapping.map(this.findById(userId))));
    }

    @Override
    public UserDTO findByUserName(String userName) {
        log.info("Find user by username");
        return UserMapping.map(this.userRepository.findByCredentialUserName(userName).orElseThrow(() -> new UserObjectNotFoundException(String.format("User with username: %s not found", userName))));
    }

    @Override
    public void deleteById(Integer userId) {
        log.info("Delete user by Id");
        this.userRepository.deleteById(userId);
    }

    @Override
    public void activeAccount(String email) {
        String activationToken = jwtUtil.generateToken(email);
        emailService.sendSimpleMessage(email, "Account Activation", "Your activation token: " + activationToken);
    }

    @Override
    public void forgotPassword(String email) {
        String resetToken = jwtUtil.generateToken(email);
        emailService.sendSimpleMessage(email, "Reset password", "Your password reset: " + resetToken);
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        String username = jwtUtil.extractUserName(token);
        if (username == null || !jwtUtil.validateToken(token, username)) {
            throw new IllegalArgumentException("Invalid or expired token");
        }
        User user = userRepository.findByCredentialUserName(username)
                .orElseThrow(() -> new UserObjectNotFoundException("User not found"));
        user.getCredential().setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.save(user);
    }
}
