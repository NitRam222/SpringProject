package spring.service;

import spring.service.user.NewUser;
import spring.service.user.User;
import spring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody NewUser newUser) {
        return userService.create(newUser);
    }
}
