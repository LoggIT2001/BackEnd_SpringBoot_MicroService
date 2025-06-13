package HappyProject.User_Service.Service;

import HappyProject.User_Service.Model.DTO.AddressDTO;
import org.hibernate.validator.constraints.Email;

import java.util.List;

public interface AddressService {
    List<AddressDTO> fillAll();
    AddressDTO findById(final Integer addressId);
    AddressDTO save(final AddressDTO addressDTO);
    AddressDTO update(final AddressDTO addressDTO);
    AddressDTO update(final Integer addressId, final AddressDTO addressDTO);
    void deleteById(final Integer addressId);
}
