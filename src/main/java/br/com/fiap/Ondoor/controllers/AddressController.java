package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    Logger log = LoggerFactory.getLogger(AddressController.class);

    List<Address> addresses = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok().body(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Address address = addresses.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (address == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(address);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Address address) {
        addresses.add(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Address address) {
        log.info("alterando endereço com id " + id);
        var ads = addresses.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (ads.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        addresses.remove(ads);
        address.setId(id);
        addresses.add(address);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public void delete(@PathVariable Long id) {
        addresses.get(Integer.parseInt(String.valueOf(id)));
        ResponseEntity.ok().build();
    }

}
