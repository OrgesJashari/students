package org.example.app.db.repsitory;

import org.example.app.db.DBConnection;
import org.example.app.db.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private DBConnection dbConnection;

    public StudentRepository(DBConnection connection) {
        this.dbConnection = connection;
    }

    public void createStudent(Student student) {
        String query = "inster into studentet (name , age) values (?,?)";

        try (Connection lidhja = this.dbConnection.getConnection();
             PreparedStatement urdheri = lidhja.prepareStatement(query)

        ) {
            urdheri.setString(1, student.getName());
            urdheri.setInt(2, student.getAge());
            urdheri.executeUpdate();


        } catch (SQLException e) {
            System.out.println("nuk mujta me shtu studentin ");
            e.printStackTrace();

        }
    }

    public Student findStudentById(long id) {
        String query = "select * from students where id = ?";

        try (Connection lidhja = this.dbConnection.getConnection();
             PreparedStatement urdheri = lidhja.prepareStatement(query)

        ) {
            urdheri.setString(1, String.valueOf(id));
            ResultSet response = urdheri.executeQuery();
            if (response.next()) {
                return new Student(response.getLong("id"), response.getString("name"), response.getInt("age"));
            }


        } catch (SQLException e) {
            System.out.println("nuk mujta me shtu studentin ");
            e.printStackTrace();

        }


        return null;
    }

    public List<Student> kthejTeGjitheStudentet() {
        String query = "SELECT * FROM studentet";
        List<Student> studentList = new ArrayList<>();


        try (Connection lidhja = this.dbConnection.getConnection();
             PreparedStatement urdher = lidhja.prepareStatement(query);
             ResultSet respons = urdher.executeQuery()) {


            while (respons.next()) {
                Student student = new Student(
                        respons.getLong("id"),
                        respons.getString("name"),
                        respons.getInt("age")
                );
                studentList.add(student);
            }


        } catch (SQLException e) {
            System.out.println("Nuk mujta me i kthy studentet");
            e.printStackTrace();
        }
        return studentList;
    }

    public void updateStudent(long id, Student student) {
        String query = "Update studentet ";

        try (Connection lidhja = this.dbConnection.getConnection();
             PreparedStatement urdheri = lidhja.prepareStatement(query)


        ) {
            urdheri.setString(1, student.getName());
            urdheri.setInt(2, student.getAge());
            urdheri.setLong(3, id);
            urdheri.executeUpdate();


        } catch (SQLException e) {
            System.out.println("nuk mujta me update studentin ");
            e.printStackTrace();


        }
    }
        public void deleteStudentBtId (long id, Student student){
            String query = "DELETE from studentet where id =?";

            try (Connection lidhja = this.dbConnection.getConnection();
                 PreparedStatement urdheri = lidhja.prepareStatement(query)


            ) {

                urdheri.setLong(3, id);
                urdheri.executeUpdate();


            } catch (SQLException e) {
                System.out.println("nuk mujta me update studentin ");
                e.printStackTrace();


            }


        }


    }
