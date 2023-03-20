package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    Logger log = LoggerFactory.getLogger(PhoneController.class);

    List<Phone> phones = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Phone>> findAll() {
        return ResponseEntity.ok().body(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable Long id) {
        Phone phn = phones.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (phn == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(phn);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Phone phone) {
        phones.add(phone);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Phone phone) {
        log.info("alterando endereço com id " + id);
        Phone phn = phones.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (phn == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        phones.remove(phn);
        phone.setId(id);
        phones.add(phone);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        phones.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}

