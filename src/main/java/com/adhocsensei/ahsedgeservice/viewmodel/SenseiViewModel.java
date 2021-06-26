package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SenseiViewModel {

    private Long senseiId;
    private User senseiUser;
    private List<Course> senseisCourses = new ArrayList<>();

    public Long getSenseiId() {
        return senseiId;
    }

    public void setSenseiId(Long senseiId) {
        this.senseiId = senseiId;
    }

    public User getSenseiUser() {
        return senseiUser;
    }

    public void setSenseiUser(User senseiUser) {
        this.senseiUser = senseiUser;
    }

    public List<Course> getSenseisCourses() {
        return senseisCourses;
    }

    public void setSenseisCourses(List<Course> senseisCourses) {
        this.senseisCourses = senseisCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenseiViewModel that = (SenseiViewModel) o;
        return Objects.equals(getSenseiId(), that.getSenseiId()) && Objects.equals(getSenseiUser(), that.getSenseiUser()) && Objects.equals(getSenseisCourses(), that.getSenseisCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSenseiId(), getSenseiUser(), getSenseisCourses());
    }

    @Override
    public String toString() {
        return "SenseiViewModel{" +
                "senseiId=" + senseiId +
                ", senseiUser=" + senseiUser +
                ", senseisCourses=" + senseisCourses +
                '}';
    }
}
