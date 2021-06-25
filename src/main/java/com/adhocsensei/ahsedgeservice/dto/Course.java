package com.adhocsensei.ahsedgeservice.dto;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.io.Serializable;
import java.util.Objects;

@RefreshScope
public class Course implements Serializable {

    private Long courseId;
    private String title;
    private String category;

    //    add validation for date format
    private String date;

    private String shortDescription;
    private String location;
    private Integer duration;
    private Integer capacity;
    private String longDescription;
    private Long senseiId;

//    public Course() {
//    }
//
//    public Course(Long courseId, String title, String category, String date, String shortDescription, String location, Integer duration, Integer capacity, String longDescription, Long senseiId) {
//        this.courseId = courseId;
//        this.title = title;
//        this.category = category;
//        this.date = date;
//        this.shortDescription = shortDescription;
//        this.location = location;
//        this.duration = duration;
//        this.capacity = capacity;
//        this.longDescription = longDescription;
//        this.senseiId = senseiId;
//    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getSenseiId() {
        return senseiId;
    }

    public void setSenseiId(Long senseiId) {
        this.senseiId = senseiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseId(), course.getCourseId()) && Objects.equals(getTitle(), course.getTitle()) && Objects.equals(getCategory(), course.getCategory()) && Objects.equals(getDate(), course.getDate()) && Objects.equals(getShortDescription(), course.getShortDescription()) && Objects.equals(getLocation(), course.getLocation()) && Objects.equals(getDuration(), course.getDuration()) && Objects.equals(getCapacity(), course.getCapacity()) && Objects.equals(getLongDescription(), course.getLongDescription()) && Objects.equals(getSenseiId(), course.getSenseiId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getTitle(), getCategory(), getDate(), getShortDescription(), getLocation(), getDuration(), getCapacity(), getLongDescription(), getSenseiId());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", location='" + location + '\'' +
                ", duration=" + duration +
                ", capacity=" + capacity +
                ", longDescription='" + longDescription + '\'' +
                ", senseiId=" + senseiId +
                '}';
    }
}