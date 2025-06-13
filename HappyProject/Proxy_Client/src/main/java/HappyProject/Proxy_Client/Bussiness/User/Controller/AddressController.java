package HappyProject.Proxy_Client.Bussiness.User.Controller;

import HappyProject.Proxy_Client.Bussiness.User.Model.DTO.AddressDTO;
import HappyProject.Proxy_Client.Bussiness.User.Model.Response.AddressUseServiceResponse;
import HappyProject.Proxy_Client.Bussiness.User.Service.AddressClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressClientService addressClientService;

    @GetMapping
    public ResponseEntity<AddressUseServiceResponse> findAll(){
        return ResponseEntity.ok(this.addressClientService.findAll().getBody());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("addressId") final String addressId){
        return ResponseEntity.ok(this.addressClientService.findById(addressId).getBody());
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody final AddressDTO addressDTO){
        return ResponseEntity.ok(this.addressClientService.save(addressDTO).getBody());
    }

    @PutMapping
    public ResponseEntity<AddressDTO> update(@RequestBody final AddressDTO addressDTO){
        return ResponseEntity.ok(this.addressClientService.update(addressDTO).getBody());
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDTO> update(@PathVariable("addressId") final String addressId, final AddressDTO addressDTO){
        return ResponseEntity.ok(this.addressClientService.update(addressDTO).getBody());
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> delete(@PathVariable("addressId") final String addressId){
        return ResponseEntity.ok(this.addressClientService.deleteById(addressId).getBody());
    }
}
