/*
 * @ (#) Course.java       1.0  8/30/2024
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
 

public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;


    /**
     * Description: Constructor with parameters
     *
     * @param id The ID of the course
     * @param title The title of the course
     * @param credit The credit of the course
     * @param department The department of the course
     */
    public Course(String id, int credit, String title, String department) {
        this.id = id;
        this.credit = credit;
        this.title = title;
        this.department = department;
    }

    /**
     * Description: Default constructor
     */
    public Course(){
        this("", 0, "", "");

    }

    public Course(String id, String title, int credit, String department) {
    }

    public String getId() {
        return id;
    }
    /**
     * Description: Set the ID of the course
     * @param id The ID of the course
     * @throws IllegalArgumentException if id is null, id length is less than 3, or id contains characters other than letters or digits
     */
    public void setId(String id) {
        if (id == null || id.trim().length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        int len = id.length();
        for (int i =0; i < len; i++) {
            char ch = id.charAt(i);
            if(!Character.isLetterOrDigit(ch))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    /**
     * Description: Get the title of the course
     * @return The title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * Description: Set the title of the course
     * @param title The title of the course
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }
    /**
     * Description: Set the credit of the course
     * @param credit The credit of the course
     * @throws IllegalArgumentException if credit is less than 0
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s  %10d     %-20s", id, title, credit, department);
    }


}
