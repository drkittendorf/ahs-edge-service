package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.Course;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentViewModel {

    private Long studentId;
    private User studentUser;
    private List<Course> studentCourses = new ArrayList<>();

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public User getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(User studentUser) {
        this.studentUser = studentUser;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentViewModel that = (StudentViewModel) o;
        return Objects.equals(getStudentId(), that.getStudentId()) && Objects.equals(getStudentUser(), that.getStudentUser()) && Objects.equals(getStudentCourses(), that.getStudentCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getStudentUser(), getStudentCourses());
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "studentId=" + studentId +
                ", studentUser=" + studentUser +
                ", studentCourses=" + studentCourses +
                '}';
    }
}
