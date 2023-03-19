package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/user")
    public User show() { return new User();}
        @Autowired
        private UserService userService;

        @GetMapping
        public List<User> findAll() {
            return userService.findAll();
        }

        @GetMapping("/{id}")
        public User findById(@PathVariable Long id) {
            return userService.findById(id);
        }

        @PostMapping
        public User save(@RequestBody User user) {
            return userService.save(user);
        }

        @PutMapping("/{id}")
        public User update(@PathVariable Long id, @RequestBody User user) {
            User existingUser = userService.findById(id);
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userService.save(existingUser);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            userService.delete(id);
        }

}



