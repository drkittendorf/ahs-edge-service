package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.User;
import com.adhocsensei.ahsedgeservice.service.AdHocSenseiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdHocSenseiController {

    @Autowired
    AdHocSenseiService service;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        System.out.println("Called the edge service, get all users");
        return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        System.out.println("calling the edge service, getting user by id");
        return service.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("calling the edge service, updating user by id");
        service.updateUser(id,user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        System.out.println("calling the edge service, deleting user by id");
        service.deleteUserById(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        System.out.println("calling the edge service, logging in user");
        return service.loginUser(user);
    }

    @PostMapping("/register")
    public User addAUser(@RequestBody User user) {
        System.out.println("calling in edge service, making a user");
        return service.createUser(user);
    }

//    this should be used for sensei to add course, maybe route should be "create_course"
    @PostMapping("/senseidash/{id}/course")
    public Course addACourse(@PathVariable Long id, @RequestBody Course course) {
        System.out.println("calling in edge for a sensei to make a course");
        return service.buildACourse(id, course);
    }

    @PostMapping("/studentdash/{id}")
    public User registerForACourse(@PathVariable Long id,@RequestBody Course course) {
        System.out.println("calling in edge for a student to register for a course");
        return service.addARegisteredCourse(id, course);
    }

    @GetMapping("/course")
    public List<Course> getAllCourses(@RequestParam(required = false) String title,
                                         @RequestParam(required = false) String category,
                                         @RequestParam(required = false) String location,
                                         @RequestParam(required = false) String date,
                                         @RequestParam(required = false) Long senseiId) {
        System.out.println("calling in edge service, getting all courses");
        return service.getAllCourses(title,category,location,date,senseiId);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        System.out.println("calling the edge service, getting course by id");
        return service.getCourseById(id);
    }

    @PutMapping("/course/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody Course course) {
        System.out.println("calling the edge service, updating course by id");
        service.updateCourse(id,course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        System.out.println("calling the edge service, deleting course by id");
        service.deleteCourseById(id);
    }
}
