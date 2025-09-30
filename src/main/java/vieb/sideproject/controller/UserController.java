package vieb.sideproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vieb.sideproject.entity.User;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @GetMapping
    public ResponseEntity<User> getUsers() {
        return ResponseEntity.ok(User.builder()
                .id(1L)
                .username("user1")
                .password("pwd")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(User.builder()
                .id(Long.valueOf(id))
                .username("user " + id)
                .password("pwd")
                .build());
    }
}
