package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        if (!this.enrolledCourses.containsKey(course.getCode())) {
            this.enrolledCourses.put(course.getCode(), new EnrolledCourse(course));
            return true;
        }
        else {
            return false;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course

        for (EnrolledCourse course: getEnrolledCourses().values()) {
            if (course.getCode().equals(courseCode)) {
                course.setGrade(grade);
            }
        }

    }

    public Course findCourseById( String courseId )
    {
        //TODO return the enrolled course with the course Id


        for (Course  course: getEnrolledCourses().values()) {
            if (course.getCode().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade

        HashMap<String, EnrolledCourse> passedCourse = new HashMap<>();   //new hashMap to store all the passed courses
        double passingGrade = 3.0;      //3.0 is the passing grade

        for (String courseCode: enrolledCourses.keySet()) {
            EnrolledCourse course = enrolledCourses.get(courseCode);
            if (course.getGrade() >= passingGrade) {
                passedCourse.put(courseCode, course);
            }

        }
        return passedCourse;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
