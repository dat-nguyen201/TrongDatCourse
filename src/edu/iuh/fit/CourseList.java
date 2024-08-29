/*
 * @ (#) CourseList.java       1.0  8/30/2024
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
 

public class CourseList {
    private Course[] courses;
    private int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     */

    public CourseList(int n) {
        if (n<=0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    /**
     * Description: Add a course to the list
     * @param course
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course) {
        //check if course is null
        if (course==null)
            return false;
        //check if course already exits
        if (isExits(course))
            return false;
        //check if array is full
        if (count==courses.length)
            return false;
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean isExits(Course course) {
        for (int i=0; i<count; i++){
            if (courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }
    //find course using id
    public Course findCourseByID(String courseId) {
        if (courseId == null || courseId.isEmpty())
            return null;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(courseId)) {
                return courses[i];
            }
        }

        return null;
    }

    // Method to find courses by title
    public Course[] findCourseByTitle(String courseName) {
        // Create temporary result array
        Course[] result = new Course[count];
        int resultCount = 0;

        if (courseName == null || courseName.isEmpty()) return null;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(courseName.toLowerCase())) {
                result[i] = courses[i];
                resultCount++;
            }
        }

        if (resultCount == 0) return null;

        // Create array with true size
        Course[] foundCourses = new Course[resultCount];
        System.arraycopy(result, 0, foundCourses, 0, resultCount);

        return foundCourses;
    }


    // Method to find courses by department
    public Course[] findCoursesByDepartment(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) return null;
        Course[] result = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getDepartment().equalsIgnoreCase(departmentName)) {
                result[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) return null;
        Course[] foundCourses = new Course[resultCount];
        System.arraycopy(result, 0, foundCourses, 0, resultCount);
        return foundCourses;
    }

    public Course[] findCoursesByTitle(String courseName) {
        Course[] result = new Course[count];
        int resultCount = 0;
        if (courseName == null || courseName.isEmpty()) return null;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getTitle().toLowerCase().contains(courseName.toLowerCase())) {
                result[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) return null;
        Course[] foundCourses = new Course[resultCount];
        System.arraycopy(result, 0, foundCourses, 0, resultCount);
        return foundCourses;
    }

    public void sortCoursesByTitle() {
        boolean swapped;
        for (int i = 0; i < count - 1; i++) {
            swapped = false;
            for (int j = 0; j < count - i - 1; j++) {
                if (courses[j] != null && courses[j + 1] != null &&
                        courses[j].getTitle().compareToIgnoreCase(courses[j + 1].getTitle()) > 0) {
                    // Swap courses[j] and courses[j + 1]
                    Course temp = courses[j];
                    courses[j] = courses[j + 1];
                    courses[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    public Course findCourseWithMaxCredit() {
        if (count == 0) return null;

        Course maxCreditCourse = courses[0];
        for (int i = 1; i < count; i++) {
            if (courses[i] != null && courses[i].getCredit() > maxCreditCourse.getCredit()) {
                maxCreditCourse = courses[i];
            }
        }
        return maxCreditCourse;
    }

    public String departmentWithMostCourses() {
        if (count == 0) return null;

        String[] departments = new String[count];
        int[] departmentCounts = new int[count];
        int numDepartments = 0;

        // Count the number of courses in each department
        for (int i = 0; i < count; i++) {
            if (courses[i] != null) {
                String department = courses[i].getDepartment();
                boolean found = false;

                // Check if department is already counted
                for (int j = 0; j < numDepartments; j++) {
                    if (departments[j].equalsIgnoreCase(department)) {
                        departmentCounts[j]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    departments[numDepartments] = department;
                    departmentCounts[numDepartments] = 1;
                    numDepartments++;
                }
            }
        }

        // Find the department with the maximum count
        String maxDepartment = null;
        int maxCount = 0;

        for (int i = 0; i < numDepartments; i++) {
            if (departmentCounts[i] > maxCount) {
                maxDepartment = departments[i];
                maxCount = departmentCounts[i];
            }
        }

        return maxDepartment;
    }
}
