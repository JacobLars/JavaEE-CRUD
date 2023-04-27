/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Student;

/**
 *
 * @author Jacob
 */
@Stateless
public class StudentManager {

    @PersistenceContext
    EntityManager em;

    public void updateStudentName(Long id, String newName) {

        Student student = em.find(Student.class, id);

        student.setName(newName);

    }

    public void updateStudentAge(Long id, Integer newAge) {

        Student student = em.find(Student.class, id);

        student.setAge(newAge);

    }

    public void removeStudentById(Long id) {

        Student student = em.find(Student.class, id);

        em.remove(student);

    }

    public void addStudent(Student s) {

        em.persist(s);

    }

    public List<Student> getAllStudents() {

        Query q = em.createQuery("SELECT s FROM Student s");

        return q.getResultList();

    }

    public Student getStudent(Long id){
        
        Student student = em.find(Student.class, id);
        
        return student;
    }
    
}
