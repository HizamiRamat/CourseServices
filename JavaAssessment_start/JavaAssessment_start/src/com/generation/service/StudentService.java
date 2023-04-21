package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        this.students.put(student.getId(), student);

    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        if(this.students.containsKey(studentId)) {
            return this.students.get(studentId);
        }
        return null;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have add the course to the student enrolledCourse
        if (this.students.containsKey(studentId)) {
            Student student = this.students.get(studentId);
            student.enrollToCourse(course);
        }
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses

        for ( String key : students.keySet() )
        {
            Student student = students.get( key );
            System.out.println( student );
            for (EnrolledCourse course : student.getEnrolledCourses().values()) {
                System.out.println(" Enrolled Courses: " + course.toString());
            }
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses

        return student.getEnrolledCourses();
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id

        if(this.enrolledCourses(student).containsKey(courseId)) {
            return this.enrolledCourses(student).get(courseId);
        }

        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
