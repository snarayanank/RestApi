package com.school.restApi.service;

import com.school.restApi.dao.Student;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class StudentDaoService {

    private static List<Student> students = new ArrayList<>();
    private int studentCount=3;
    static
    {
        students.add(new Student(1, "Sathiya", "Narayanan", "Sec2", "Indian"));
        students.add(new Student(2, "Thaswika", "Sathiya", "Primary6", "Indian"));
        students.add(new Student(3, "Vani", "Sathiya", "Sec4", "Indian"));
    }
    public List<Student> findAll(){
        return students;
    }

    public Student saveStudent(Student student){
        if(student.getId()== null){
            student.setId(++studentCount);
        }
        students.add(student);
        return student;
    }

    public Student findStudent(int id){
        for(Student student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public Student deleteById(int id){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId() == id){
                iterator.remove();
                return student;
            }
        }
        return null;
    }

    public Student updateStudent(int id, Student student){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student stu = iterator.next();
            if(stu.getId() == id){
                stu.setClassName(student.getClassName());
                return stu;
            }
        }
        return null;
    }
}
