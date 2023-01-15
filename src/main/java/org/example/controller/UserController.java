package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.user.UserRequest;
import org.example.model.user.UserResponse;
import org.example.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("list")
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("findById/{id}")
    public UserResponse findById(@PathVariable("id") Integer id) {

        return userService.findById(id);
    }

    @PatchMapping("update/{id}")
    public void updateUserById(@PathVariable Integer id, @RequestBody @Valid UserRequest userRequest) {
        userService.update(id, userRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}
