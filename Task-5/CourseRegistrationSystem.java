import java.util.*;

class Course {
    String courseCode;
    String title;
    int capacity;
    List<String> enrolledStudents;

    Course(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    void displayCourse() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Capacity: " + enrolledStudents.size() + "/" + capacity);
        System.out.println("--------------------------");
    }
}

class Student {
    String studentId;
    String name;
    List<String> registeredCourses;

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses: " + registeredCourses);
    }
}

public class CourseRegistrationSystem {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        courses.add(new Course("CHE101", "Chemistry", 3));
        courses.add(new Course("BIO105", "Biology", 2));
        courses.add(new Course("PHY103", "Physics I", 4));

        System.out.println("Welcome to the Course Registration System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. List Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerCourse(sc);
                    break;
                case 3:
                    dropCourse(sc);
                    break;
                case 4:
                    viewRegisteredCourses(sc);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayCourse();
        }
    }

    static void registerCourse(Scanner sc) {
        System.out.print("Enter your Student ID: ");
        String studentId = sc.next();
        System.out.print("Enter your name: ");
        String name = sc.next();

        Student student = findOrCreateStudent(studentId, name);

        listCourses();
        System.out.print("Enter the Course Code to register: ");
        String courseCode = sc.next();

        for (Course course : courses) {
            if (course.courseCode.equalsIgnoreCase(courseCode)) {
                if (course.enrolledStudents.size() < course.capacity) {
                    course.enrolledStudents.add(studentId);
                    student.registeredCourses.add(courseCode);
                    System.out.println("Successfully registered for " + course.title);
                } else {
                    System.out.println("Registration failed: Course is full.");
                }
                return;
            }
        }
        System.out.println("Course not found!");
    }

    static void dropCourse(Scanner sc) {
        System.out.print("Enter your Student ID: ");
        String studentId = sc.next();

        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Registered Courses:");
        for (String courseCode : student.registeredCourses) {
            System.out.println(courseCode);
        }
        System.out.print("Enter the Course Code to drop: ");
        String courseCode = sc.next();

        if (student.registeredCourses.remove(courseCode)) {
            for (Course course : courses) {
                if (course.courseCode.equalsIgnoreCase(courseCode)) {
                    course.enrolledStudents.remove(studentId);
                    System.out.println("Successfully dropped the course " + course.title);
                    return;
                }
            }
        } else {
            System.out.println("You are not registered for this course!");
        }
    }

    static void viewRegisteredCourses(Scanner sc) {
        System.out.print("Enter your Student ID: ");
        String studentId = sc.next();

        Student student = findStudent(studentId);
        if (student == null || student.registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        System.out.println("Registered Courses:");
        for (String courseCode : student.registeredCourses) {
            System.out.println(courseCode);
        }
    }

    static Student findOrCreateStudent(String studentId, String name) {
        for (Student student : students) {
            if (student.studentId.equals(studentId)) {
                return student;
            }
        }
        Student newStudent = new Student(studentId, name);
        students.add(newStudent);
        return newStudent;
    }
    static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.studentId.equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
