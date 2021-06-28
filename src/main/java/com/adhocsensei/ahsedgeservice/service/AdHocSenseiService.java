package com.adhocsensei.ahsedgeservice.service;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.User;
import com.adhocsensei.ahsedgeservice.util.feign.CourseClient;
import com.adhocsensei.ahsedgeservice.util.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RefreshScope
public class AdHocSenseiService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private CourseClient courseClient;

    public List<User> getAllUsers() {
        System.out.println("Service layer getting all users");
        return userClient.getAllUsers();
    }

    public User createUser(@RequestBody User user) {
        if (user.isInstructor()) {
            user.setAuthority("SENSEI");
        } else user.setAuthority("STUDENT");
        User createdUser = userClient.createUser(user);

        return createdUser;
    }

    public User getUserById(@PathVariable Long id) {
        System.out.println("service layer getting a user by id");
        return userClient.getUserById(id);
    }

    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("service layer updating a user by id");
        User userOptional = userClient.getUserById(id);
        if (userOptional != null) {
            user.setId(id);
            userClient.updateUser(id, user);
        }
    }

    public void deleteUserById(@PathVariable Long id) {
        System.out.println("service later deleting user by id");
        User userToDelete = userClient.getUserById(id);
        System.out.println(userToDelete);

        userToDelete.setStudentsRegisteredCourses(null);
        System.out.println("after setting to null, user is now " +userToDelete);

        userClient.deleteUserById(id);
    }

    public User loginUser(@RequestBody User user) throws Exception {
        System.out.println("service layer logging in a user");
//        throw exception for invalid login
//        throw new InvalidUserCredentialsException(user);

//        String userEmail = user.getEmail();
//
        if (user.getEmail().equals(userClient.getUserByEmail(user).getEmail())) {

            if (user.getPassword().equals(userClient.getUserByEmail(user).getPassword())) {
                return userClient.loginUser(user);
            }
//            return userClient.loginUser(user);
            throw new Exception();
        }
//        add exception handling to return statement saying username or password is incorrect
//        return userClient.loginUser(user);
        throw new Exception();
//        throw new Exception(String.valueOf(userToLogin));
    }

    public List<Course> getAllCourses(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String location,
                                      @RequestParam(required = false) String date,
                                      @RequestParam(required = false) Long senseiId) {
        return courseClient.getAllCourses(title, category, location, date,senseiId);
    }

    public Course getCourseById(@PathVariable Long id) {
        System.out.println("service layer, getting course by id");
        return courseClient.getCourseById(id);
    }

    public void updateCourse(@PathVariable Long id, @RequestBody Course course) {
        System.out.println("service layer, updating course by id");
        courseClient.updateCourse(id, course);
    }

    public void deleteCourseById(@PathVariable Long id) {
        System.out.println("service layer, deleting course by id");
        courseClient.deleteCourseById(id);
    }

    public User addARegisteredCourse(@PathVariable Long id, @RequestBody Course courseToBeRegistered) {
            System.out.println("service layer, trying to register for a course");
        User student = userClient.getUserById(id);
            System.out.println(student);
        Course registeredCourse = courseClient.getCourseById(courseToBeRegistered.getId());
            System.out.println(registeredCourse);

        userClient.addCourseToListOfStudentCourses(id, registeredCourse);

        return student;
    }

    public Course buildACourse(@PathVariable Long id, @RequestBody Course courseToBeAdded) {
        System.out.println("service making a course");
        User sensei = userClient.getUserById(id);

        Course addedCourse = courseClient.createCourse(id, courseToBeAdded);
        addedCourse.setUser(sensei);
        Course desired = courseClient.getCourseById(addedCourse.getId());


        return addedCourse;
    }
}