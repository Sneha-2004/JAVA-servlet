/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementapp;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter First Name:");
                String firstName = sc.nextLine();
                System.out.println("Enter Last Name:");
                String lastName = sc.nextLine();
                System.out.println("Enter Date of Birth (YYYY-MM-DD):");
                String dob = sc.nextLine();
                System.out.println("Enter Email:");
                String email = sc.nextLine();
                System.out.println("Enter Phone Number:");
                String phoneNumber = sc.nextLine();

                Student newStudent = new Student(firstName, lastName, dob, email, phoneNumber);
                StudentManager.addStudent(newStudent);
                break;

            case 2:
                System.out.println("Enter Student ID:");
                int studentId = sc.nextInt();

                Student student = StudentManager.getStudentById(studentId);
                if (student != null) {
                    System.out.println("Student Details:");
                    System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println("DOB: " + student.getDob());
                    System.out.println("Email: " + student.getEmail());
                    System.out.println("Phone: " + student.getPhoneNumber());
                } else {
                    System.out.println("Student not found!");
                }
                break;

            case 3:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
