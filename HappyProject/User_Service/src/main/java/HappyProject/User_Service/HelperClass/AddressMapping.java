package HappyProject.User_Service.HelperClass;

import HappyProject.User_Service.Model.DTO.AddressDTO;
import HappyProject.User_Service.Model.DTO.UserDTO;
import HappyProject.User_Service.Model.Entity.Address;
import HappyProject.User_Service.Model.Entity.User;

public interface AddressMapping {
    public static AddressDTO map(final Address address){
        return AddressDTO.builder().addressId(address.getAddressId())
                .fullAddress(address.getFullAddress())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .userDTO(UserDTO.builder().userId(address.getUser().getUserId())
                        .fullName(address.getUser().getFullName())
                        .email(address.getUser().getEmail())
                        .phone(address.getUser().getPhone())
                        .imageUrl(address.getUser().getImageUrl())
                        .build())
                .build();
    }

    public static Address map(final AddressDTO addressDTO){
        return Address.builder().addressId(addressDTO.getAddressId())
                .fullAddress(addressDTO.getFullAddress())
                .postalCode(addressDTO.getPostalCode())
                .city(addressDTO.getCity())
                .user(
                        User.builder().userId(addressDTO.getUserDTO().getUserId())
                                .fullName(addressDTO.getUserDTO().getFullName())
                                .email(addressDTO.getUserDTO().getEmail())
                                .phone(addressDTO.getUserDTO().getPhone())
                                .imageUrl(addressDTO.getUserDTO().getImageUrl())
                                .build())
                .build();
    }
}
