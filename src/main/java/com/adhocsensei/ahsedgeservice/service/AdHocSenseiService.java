package com.adhocsensei.ahsedgeservice.service;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.User;
import com.adhocsensei.ahsedgeservice.exception.InvalidUserCredentialsException;
import com.adhocsensei.ahsedgeservice.util.feign.CourseClient;
import com.adhocsensei.ahsedgeservice.util.feign.UserClient;
import com.adhocsensei.ahsedgeservice.viewmodel.SenseiViewModel;
import com.adhocsensei.ahsedgeservice.viewmodel.StudentViewModel;
import com.netflix.discovery.provider.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
//        System.out.println("service layer creating a user");
        if (user.isInstructor()) {
            user.setAuthority("SENSEI");
        } else user.setAuthority("STUDENT");
        return userClient.createUser(user);
    }

    public Optional<User> getUserById(@PathVariable Long id) {
        System.out.println("service layer getting a user by id");
        return userClient.getUserById(id);
    }

    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("service layer updating a user by id");
        Optional<User> userOptional = userClient.getUserById(id);
//                userRepo.findById(id);
        if (userOptional.isPresent()) {
            user.setUserId(id);
            userClient.updateUser(id, user);
        }
    }

    public void deleteUserById(@PathVariable Long id) {
        System.out.println("service later deleting user by id");
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
                                      @RequestParam(required = false) String date) {
        System.out.println("service layer, getting all courses");
        return courseClient.getAllCourses(title, category, location, date);
    }

    public Optional<Course> getCourseById(@PathVariable Long id) {
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
        User student = userClient.getUserById(id).get();
        Optional<Course> registeredCourse = courseClient.getCourseById(courseToBeRegistered.getCourseId());

        userClient.addCourseToListOfStudentCourses(student.getUserId(), registeredCourse);

        return student;
    }

    public Course buildACourse(@PathVariable Long id, @RequestBody Course courseToBeAdded) {
        User sensei = userClient.getUserById(id).get();
        courseToBeAdded.setSenseiId(sensei.getUserId());
        Course addedCourse = courseClient.createCourse(courseToBeAdded);
        userClient.addCourseToListOfSenseisCourses(sensei.getUserId(), addedCourse);

//        if (courseToBeAdded.getSenseiId() != null) {
//            List<User> senseis = userClient.getAllUsers();
//            List<User> thisSensei = senseis
//                    .stream()
//                    .filter(s -> courseToBeAdded.getSenseiId() == s.getUserId())
//                    .collect(Collectors.toList());
//            if (thisSensei.size() == 0 ) {
//                System.out.println("passed invalid user id " + courseToBeAdded.getSenseiId());
////                throw exception for invalid sensei
//            }
////            userClient.addCourseToListOfSenseisCourses(sensei.addCourseToSensei(courseToBeAdded));
////            sensei.setSenseisCreatedCourses(courseToBeAdded);
//            userClient.addCourseToListOfSenseisCourses(sensei.getUserId(),courseToBeAdded);
//        }
        return addedCourse;
    }
}