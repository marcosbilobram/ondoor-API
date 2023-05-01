package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Client;
import br.com.fiap.Ondoor.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientRepository repo;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {

        Client ads = repo.findById(id).get();

        if (ads == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(ads);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody @Valid Client Client) {
        repo.save(Client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid Client Client) {
        log.info("alterando endereço com id " + id);
        var ads = repo.findById(id);

        if (ads.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(ads.get());
        Client.setId(id);
        repo.save(Client);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}