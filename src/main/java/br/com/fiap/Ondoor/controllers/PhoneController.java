package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @GetMapping(value = "/phone")
    public Phone show() { return new Phone();}

        @Autowired
        private PhoneService phoneService;

        @GetMapping
        public List<Phone> findAll() {
            return phoneService.findAll();
        }

        @GetMapping("/{id}")
        public Phone findById(@PathVariable Long id) {
            return phoneService.findById(id);
        }

        @PostMapping
        public Phone save(@RequestBody Phone phone) {
            return phoneService.save(phone);
        }

        @PutMapping("/{id}")
        public Phone update(@PathVariable Long id, @RequestBody Phone phone) {
            Phone existingPhone = phoneService.findById(id);
            existingPhone.setClient(phone.getClient());
            existingPhone.setPhoneNumber(phone.getPhoneNumber());
            return phoneService.save(existingPhone);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            phoneService.delete(id);
        }

    }

