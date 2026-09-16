import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> marks = new ArrayList<>();

    // Add a student
    static void addStudent(Scanner sc) {

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks (0-100): ");
        int mark = sc.nextInt();
        sc.nextLine();

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        names.add(name);
        marks.add(mark);

        System.out.println("Student added successfully!");
    }

    // Calculate grade
    static String calculateGrade(int mark) {

        if (mark >= 90) {
            return "A";
        } else if (mark >= 80) {
            return "B";
        } else if (mark >= 70) {
            return "C";
        } else if (mark >= 60) {
            return "D";
        } else if (mark >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    // Display all students
    static void displayStudents() {

        if (names.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== STUDENT DETAILS =====");

        for (int i = 0; i < names.size(); i++) {

            int mark = marks.get(i);

            System.out.println(
                (i + 1) + ". " +
                names.get(i) +
                " | Marks: " + mark +
                " | Grade: " + calculateGrade(mark) +
                " | Status: " + (mark >= 40 ? "Pass" : "Fail")
            );
        }
    }

    // Calculate average
    static void calculateAverage() {

        if (marks.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        double average = (double) sum / marks.size();

        System.out.println("Average marks: " + average);
    }

    // Find highest score
    static void findHighest() {

        if (marks.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        int highest = marks.get(0);
        String student = names.get(0);

        for (int i = 1; i < marks.size(); i++) {

            if (marks.get(i) > highest) {
                highest = marks.get(i);
                student = names.get(i);
            }
        }

        System.out.println("Highest score: " + highest);
        System.out.println("Student: " + student);
    }

    // Find lowest score
    static void findLowest() {

        if (marks.size() == 0) {
            System.out.println("No students available.");
            return;
        }

        int lowest = marks.get(0);
        String student = names.get(0);

        for (int i = 1; i < marks.size(); i++) {

            if (marks.get(i) < lowest) {
                lowest = marks.get(i);
                student = names.get(i);
            }
        }

        System.out.println("Lowest score: " + lowest);
        System.out.println("Student: " + student);
    }

    // Search student
    static void searchStudent(Scanner sc) {

        System.out.print("Enter student name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(searchName)) {

                int mark = marks.get(i);

                System.out.println("\nStudent found!");
                System.out.println("Name: " + names.get(i));
                System.out.println("Marks: " + mark);
                System.out.println("Grade: " + calculateGrade(mark));
                System.out.println("Status: " + (mark >= 40 ? "Pass" : "Fail"));

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Update marks
    static void updateMarks(Scanner sc) {

        System.out.print("Enter student name: ");
        String searchName = sc.nextLine();

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(searchName)) {

                System.out.print("Enter new marks: ");
                int newMarks = sc.nextInt();
                sc.nextLine();

                if (newMarks < 0 || newMarks > 100) {
                    System.out.println("Invalid marks!");
                    return;
                }

                marks.set(i, newMarks);

                System.out.println("Marks updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    static void deleteStudent(Scanner sc) {

        System.out.print("Enter student name to delete: ");
        String searchName = sc.nextLine();

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(searchName)) {

                names.remove(i);
                marks.remove(i);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest Score");
            System.out.println("5. Find Lowest Score");
            System.out.println("6. Search Student");
            System.out.println("7. Update Marks");
            System.out.println("8. Delete Student");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateAverage();
                    break;

                case 4:
                    findHighest();
                    break;

                case 5:
                    findLowest();
                    break;

                case 6:
                    searchStudent(sc);
                    break;

                case 7:
                    updateMarks(sc);
                    break;

                case 8:
                    deleteStudent(sc);
                    break;

                case 9:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
