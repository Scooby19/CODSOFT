import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy courses
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("CS101", "Java Basics", "Intro to Java", "Mon-Wed 10AM",2));
        courseList.add(new Course("CS102", "Data Structures", "Learn DSA", "Tue-Thu 11AM",2));
        courseList.add(new Course("CS103", "Web Dev", "HTML/CSS/JS","Fri 2PM" ,2));

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        Student student = new Student(name, id);

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Course c : courseList) {
                        c.showDetails();
                        System.out.println("----------------");
                    }
                    break;
                case 2:
                    System.out.print("Enter course code to register: ");
                    String regCode = scanner.nextLine();
                    Course courseToRegister = findCourse(courseList, regCode);
                    if (courseToRegister != null)
                        student.registerCourses(courseToRegister);
                    else
                        System.out.println("Course not found!");
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCode = scanner.nextLine();
                    Course courseToDrop = findCourse(courseList, dropCode);
                    if (courseToDrop != null)
                        student.dropCourse(courseToDrop);
                    else
                        System.out.println("Course not found!");
                    break;
                case 4:
                    student.viewRegisteredCourse();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static Course findCourse(List<Course> list, String code) {
        for (Course c : list) {
            if (c.code.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}

