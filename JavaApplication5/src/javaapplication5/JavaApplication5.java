/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author jatinagrawal
 */
import java.sql.*;
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */



     int studentId;
    String name;
     String course;
    String u="root";
    String p="Jatin@1234";

    public JavaApplication5(int studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }
    public void enroll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrollment", u, p);

      
            String sql = "INSERT INTO students (student_id, name, course) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, course);


            preparedStatement.executeUpdate();

            System.out.println("Enrollment successful!");
        } catch (SQLException e) {
            System.out.println(e);
        } 
        
    }

 
    public static void main(String[] args) {
        JavaApplication5 student = new JavaApplication5(123, "Jatin", "Mathematics");
        student.enroll();
    }
}


    

    
