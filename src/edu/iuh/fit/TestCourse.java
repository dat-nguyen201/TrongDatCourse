/*
 * @ (#) TestCourse.java       1.0  8/30/2024
 *   
 * Copyright (c) 2024 IUH. All rights reserred
 */
 
package edu.iuh.fit;


/*
 * @description:
 * @author: Nguyen Trong Dat
 * @date:   8/30/2024
 * @version:    1.0
 */

import java.util.Scanner;
public class TestCourse {
    public static void main(String[] args) {

        CourseList courseList = new CourseList(6);
        initData(courseList);
        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find a course by ID");
            System.out.println("5. Find courses by Title");
            System.out.println("6. Find courses by Department");
            System.out.println("7. Sort courses by title");
            System.out.println("8. Find course with maximum credit");
            System.out.println("9. Find department with most courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, credit, title, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println(String.format("%-10s%-30s%13s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.print("Enter the course ID to remove: ");
                    String courseId = sc.nextLine();
                    for (int i = 0; i < courseList.getCourses().length; i++) {
                        Course course = courseList.getCourses()[i];
                        if (course != null && course.getId().equals(courseId)) {
                            courseList.getCourses()[i] = null;
                            System.out.println("Course removed successfully!");
                        }
                        else
                            System.out.println("Course not found!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter the course ID to find: ");
                    String courseId = sc.nextLine();
                    Course course = courseList.findCourseByID(courseId);
                    if (course != null) {
                        System.out.println("Course found:");
                        System.out.println(String.format("%-10s%-30s%13s %-10s", "ID", "Title", "Credit", "Department"));
                        System.out.println(course);
                    } else {
                        System.out.println("Course not found!");
                    }
                }
                case 5 -> {
                    System.out.print("Enter the course title to find: ");
                    String courseName = sc.nextLine();
                    Course[] courses = courseList.findCoursesByTitle(courseName);
                    if (courses != null && courses.length > 0) {
                        System.out.println("Courses found:");
                        for (Course course : courses) {
                            System.out.println(String.format("%-10s%-30s%5d %-10s",
                                    course.getId(), course.getTitle(), course.getCredit(), course.getDepartment()));
                        }
                    } else {
                        System.out.println("No courses found with that title!");
                    }

                }

                case 6 -> {
                    System.out.print("Enter the department to find courses: ");
                    String department = sc.nextLine();
                    Course[] courses = courseList.findCoursesByDepartment(department);
                    if (courses != null && courses.length > 0) {
                        System.out.println("Courses found:");
                        for (Course course : courses) {
                            System.out.println(String.format("%-10s%-30s%5d %-10s",
                                    course.getId(), course.getTitle(), course.getCredit(), course.getDepartment()));
                        }
                    } else {
                        System.out.println("No courses found in that department!");
                    }
                }


                case 7 -> {
                    courseList.sortCoursesByTitle();
                    System.out.println("Courses sorted by title.");
                    // Display sorted courses
                    System.out.println(String.format("%-10s%-30s%5s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null) {
                            System.out.println(String.format("%-10s%-30s%5d %-10s",
                                    c.getId(), c.getTitle(), c.getCredit(), c.getDepartment()));
                        }
                    }
                    System.out.println("-------------------------------------------------------------");
                }

                case 8 -> {
                    Course maxCreditCourse = courseList.findCourseWithMaxCredit();
                    if (maxCreditCourse != null) {
                        System.out.println("Course with maximum credit:");
                        System.out.println(String.format("%-10s%-30s%5d %-10s",
                                maxCreditCourse.getId(), maxCreditCourse.getTitle(), maxCreditCourse.getCredit(), maxCreditCourse.getDepartment()));
                    } else {
                        System.out.println("No courses available to find the maximum credit course!");
                    }
                }

                case 9 -> {
                    String departmentWithMostCourses = courseList.departmentWithMostCourses();
                    if (departmentWithMostCourses != null) {
                        System.out.println("Department with the most courses: " + departmentWithMostCourses);
                    } else {
                        System.out.println("No departments available!");
                    }
                }

                default ->
                        System.out.println("Invalid choice!");
            }
        } while (choice != 0);

    }

    private static void initData(CourseList courseList) {
        Course c1 = new Course("CS101",    3 , "Java Programing",   "CS");
        Course c2 = new Course("IS201", 1 , "Database Programing",  "IS");
        Course c3 = new Course("SE301", 2 , "C# Programing",    "SE");
        Course c4 = new Course("SE102",  4 , "C++ Programing",   "SE");
        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
    }
}
