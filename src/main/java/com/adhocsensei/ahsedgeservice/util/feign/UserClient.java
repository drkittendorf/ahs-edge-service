package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.User;
//import com.adhocsensei.ahsedgeservice.viewmodel.SenseiViewModel;
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

    @GetMapping("/user/email")
    public User getUserByEmail(@RequestBody User user);

    @PostMapping("/user")
    public User createUser(@RequestBody User user);

    @PostMapping("/senseidash/{id}")
    public User addCourseToListOfSenseisCourses(@PathVariable Long id, @RequestBody Course senseiCourse);

    @PostMapping("/studentdash/{id}")
    public User addCourseToListOfStudentCourses(@PathVariable Long id, @RequestBody Optional<Course> studentCourse);

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user);

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id);

    @PostMapping("/login")
    public User loginUser(@RequestBody User user);
}
