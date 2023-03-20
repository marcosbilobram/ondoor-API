package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @GetMapping(value = "/address")
    public Address show(){
        return new Address();
    }

    @Autowired
    private Address address;

    @GetMapping
    public List<Address> findAll() {
        return address.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return address.findById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return address.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address) {
        Address existingAddress = address.findById(id);
        existingAddress.setStreet(address.getStreet());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setZipCode(address.getZipCode());
        return address.save(existingAddress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        address.delete(id);
    }

}
