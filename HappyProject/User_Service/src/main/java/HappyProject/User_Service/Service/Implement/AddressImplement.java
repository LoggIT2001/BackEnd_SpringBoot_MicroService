package HappyProject.User_Service.Service.Implement;

import HappyProject.User_Service.Exceptions.AddressNotFoundException;
import HappyProject.User_Service.HelperClass.AddressMapping;
import HappyProject.User_Service.Model.DTO.AddressDTO;
import HappyProject.User_Service.Repository.AddressRepository;
import HappyProject.User_Service.Service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AddressImplement implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressImplement(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDTO> fillAll() {
        log.info("AddressDTO, fetch the all address");
        return this.addressRepository.findAll().stream().map(AddressMapping::map).distinct().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public AddressDTO findById(Integer addressId) {
        log.info("AddressDTO fetch the address by using id");
        return this.addressRepository.findById(addressId).map(AddressMapping::map).orElseThrow(() -> new AddressNotFoundException(String.format("Address with id: %d not found", addressId)));
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.info("AddressDTO save the address");
        return AddressMapping.map(this.addressRepository.save(AddressMapping.map(addressDTO)));
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        log.info("AddressDTO update the address");
        return AddressMapping.map(this.addressRepository.save(AddressMapping.map(addressDTO)));
    }

    @Override
    public AddressDTO update(Integer addressId, AddressDTO addressDTO) {
        log.info("AddressDTO update the address by addressId");
        return AddressMapping.map(this.addressRepository.save(AddressMapping.map(this.findById(addressId))));
    }

    @Override
    public void deleteById(Integer addressId) {
        log.info("Delete the address by AddressId");
        this.addressRepository.deleteById(addressId);
    }
}
