package HappyProject.User_Service.Controller;

import HappyProject.User_Service.Model.DTO.AddressDTO;
import HappyProject.User_Service.Response.ResponseCollectionDTO;
import HappyProject.User_Service.Service.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<AddressDTO>> findAll(){
        log.info("Address Controller, find all the address");
        return ResponseEntity.ok(new ResponseCollectionDTO<>(this.addressService.fillAll()));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("addressId") @NotBlank(message = "Input is not blank") @Valid String addressId){
        log.info("Address Controller, find the address by id");
        return ResponseEntity.ok(this.addressService.findById(Integer.parseInt(addressId.strip())));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @NotNull(message = "Input must not null") @Valid AddressDTO addressDTO){
        log.info("Address Controller, save the address");
        return ResponseEntity.ok(this.addressService.save(addressDTO));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDTO> update(@RequestBody @PathVariable("addressId") @NotNull(message = "Input must not null") @Valid AddressDTO addressDTO){
        log.info("Address Controller, Update the address");
        return ResponseEntity.ok(this.addressService.update(addressDTO));
    }

    @DeleteMapping("/addressId")
    public ResponseEntity<Boolean> deleteById(@PathVariable("addressId") @NotBlank(message = "Input must not blank") @Valid final String addressId) {
        log.info("Address Controller, Delete the Address");
        this.addressService.deleteById(Integer.parseInt(addressId));
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
