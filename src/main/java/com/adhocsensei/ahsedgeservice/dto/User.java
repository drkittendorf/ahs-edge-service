package com.adhocsensei.ahsedgeservice.dto;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@RefreshScope
public class User implements Serializable {

    private Long id;
    private String authority;
    private String firstName;
    private String lastName;
    //    validation for no repeats
    private String email;
    private String password;
    private String bio;
    private boolean instructor;

//    private Set<Course> senseisCreatedCourses;
    private Set<Course> studentsRegisteredCourses;

    public User() {
    }

    public User(Long id, String authority, String firstName, String lastName, String email, String password, String bio, boolean instructor, Set<Course> studentsRegisteredCourses) {
        this.id = id;
        this.authority = authority;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.instructor = instructor;
        this.studentsRegisteredCourses = studentsRegisteredCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    public Set<Course> getStudentsRegisteredCourses() {
        return studentsRegisteredCourses;
    }

    public void setStudentsRegisteredCourses(Set<Course> studentsRegisteredCourses) {
        this.studentsRegisteredCourses = studentsRegisteredCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isInstructor() == user.isInstructor() && Objects.equals(getId(), user.getId()) && Objects.equals(getAuthority(), user.getAuthority()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getBio(), user.getBio()) && Objects.equals(getStudentsRegisteredCourses(), user.getStudentsRegisteredCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthority(), getFirstName(), getLastName(), getEmail(), getPassword(), getBio(), isInstructor(), getStudentsRegisteredCourses());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", instructor=" + instructor +
                ", studentsRegisteredCourses=" + studentsRegisteredCourses +
                '}';
    }
}