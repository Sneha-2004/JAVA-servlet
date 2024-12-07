/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager {
    public static void addStudent(Student student) {
        String sql = "INSERT INTO students (first_name, last_name, dob, email, phone_number) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getDob());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public static Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        Student student = null;

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student(rs.getString("first_name"),
                                      rs.getString("last_name"),
                                      rs.getString("dob"),
                                      rs.getString("email"),
                                      rs.getString("phone_number"));
                student.setStudentId(rs.getInt("student_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching student: " + e.getMessage());
        }

        return student;
    }
}

