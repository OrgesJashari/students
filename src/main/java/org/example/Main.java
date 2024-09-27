package org.example;

import org.example.app.db.DBConnection;
import org.example.app.db.entity.Student;
import org.example.app.db.repsitory.StudentRepository;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnection dbC = new DBConnection();
        StudentRepository studentRepo = new StudentRepository(dbC);

        System.out.println(studentRepo.kthejTeGjitheStudentet());
        System.out.println("Press 1 if you want to see the list of the students");
        System.out.println("Press 2 if tou want to update a student");
        System.out.println("Press 3 if you want to update a student");
        String input = scanner.nextLine();
        if (input.equals("1")) {
            List<Student> students = studentRepo.kthejTeGjitheStudentet();
            students.stream().forEach((Student s) -> {
                System.out.println(s);
            });
        } else if (input.equals("2")) {
            System.out.println("which student do you want to update please specify by ID");
            String id = scanner.nextLine();
            Student studendi = studentRepo.findStudentById(Long.getLong(id));
            if (studendi == null) {
                System.out.println("Couldn't find student");
            } else {
                System.out.println(studendi);
                System.out.println("Please type the name and age");
                System.out.println("If you dont want to change please leave it blank");
                System.out.print("Emri:");
                String emriIRI = scanner.nextLine();
                System.out.println("Mosha:");
                int moshaERe = 0;
                String moshaInput = scanner.nextLine();
                if(!moshaInput.isEmpty()){
                    moshaERe = Integer.valueOf(moshaInput);
                }
                Student updatedStudent = new Student();
                if (emriIRI.isEmpty()) {
                    updatedStudent.setName(studendi.getName());
                } else {
                    updatedStudent.setName(emriIRI);
                }
                if (moshaERe == 0) {
                    updatedStudent.setAge(studendi.getAge());
                } else {
                    updatedStudent.setAge(moshaERe);
                }
                studentRepo.updateStudent(studendi.getId(), updatedStudent);
            }

        } else if (input.equals("3")) {
            System.out.println("Which student should i delete ");

        }

    }

}