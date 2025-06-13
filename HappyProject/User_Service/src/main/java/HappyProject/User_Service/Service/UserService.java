package HappyProject.User_Service.Service;

import HappyProject.User_Service.Model.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(final Integer userId);
    UserDTO save(final UserDTO userDTO);
    UserDTO update(final UserDTO userDTO);
    UserDTO update(final Integer userId, final UserDTO userDTO);
    UserDTO findByUserName(final String userName);
    void deleteById(final Integer userId);
    void activeAccount(String email);
    void forgotPassword(String email);
    void resetPassword(String token, String newPassword);
}
