package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    Logger log = LoggerFactory.getLogger(ClientController.class);

    List<Client> clients = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = clients.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (client == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Client client) {
        clients.add(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Client client) {
        log.info("alterando endereço com id " + id);
        Client clt = clients.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (clt == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        clients.remove(clt);
        client.setId(id);
        clients.add(client);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clients.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}