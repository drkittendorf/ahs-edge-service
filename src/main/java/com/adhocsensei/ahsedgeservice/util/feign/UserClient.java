package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user")
    public List<User> getAllUsers();

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id);

    @PostMapping("/user")
    public User createUser(@RequestBody User user);

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user);

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id);

    @GetMapping("/login")
    public String loginUser(@RequestBody User user);

//    add routes to see registered courses associated with studentId
}
