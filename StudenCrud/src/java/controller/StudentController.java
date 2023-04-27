/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Student;

/**
 *
 * @author Jacob
 */
@Named(value = "studentController")
@RequestScoped
public class StudentController {

    @Inject
    StudentManager sm;

    private String name;
    private Integer age;
    private List<Student> allStudents;
    private Long studentId;

    public void submit() {

        Student s = new Student(name, age);

        sm.addStudent(s);

        allStudents = sm.getAllStudents();

    }

    public String findStudent(){
        
        Student student = sm.getStudent(studentId);
        
        name = student.getName();
        age = student.getAge();
        
         return "findstudent";
    }

    
    
    public void removeStudent() {

        sm.removeStudentById(studentId);
        allStudents = sm.getAllStudents();
    }

    public void updateStudentAgeById() {
        sm.updateStudentAge(studentId, age);
        allStudents = sm.getAllStudents();
    }

    public void updateStudentNameById() {

        sm.updateStudentName(studentId, name);
        allStudents = sm.getAllStudents();

    }

    @PostConstruct
    public void fillArray() {

        this.allStudents = sm.getAllStudents();
    }

    public StudentController() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

}
