import java.util.Scanner;

public class StudentManagementSystem {

    static final int MAX = 100;

    static int[] ids = new int[MAX];
    static String[] names = new String[MAX];
    static int[] marks = new int[MAX];

    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average Marks");
            System.out.println("7. Display Highest Marks");
            System.out.println("8. Display Lowest Marks");
            System.out.println("9. Count Total Students");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    averageMarks();
                    break;

                case 7:
                    highestMarks();
                    break;

                case 8:
                    lowestMarks();
                    break;

                case 9:
                    totalStudents();
                    break;

                case 10:
                    System.out.println("\nThank you for using Student Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 10);
    }

    static void addStudent() {

        if (count == MAX) {
            System.out.println("Student list is full.");
            return;
        }

        System.out.print("Enter Student ID: ");
        ids[count] = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        names[count] = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        marks[count] = sc.nextInt();

        count++;

        System.out.println("Student Added Successfully.");
    }

    static void viewStudents() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n--------------------------------------------");
        System.out.printf("%-10s %-20s %-10s\n", "ID", "NAME", "MARKS");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < count; i++) {

            System.out.printf("%-10d %-20s %-10d\n",
                    ids[i], names[i], marks[i]);
        }
    }

    static void searchStudent() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (ids[i] == id) {

                System.out.println("\nStudent Found");
                System.out.println("ID : " + ids[i]);
                System.out.println("Name : " + names[i]);
                System.out.println("Marks : " + marks[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

    static void updateStudent() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (ids[i] == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                names[i] = sc.nextLine();

                System.out.print("Enter New Marks: ");
                marks[i] = sc.nextInt();

                System.out.println("Student Updated Successfully.");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

    static void deleteStudent() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (ids[i] == id) {

                for (int j = i; j < count - 1; j++) {

                    ids[j] = ids[j + 1];
                    names[j] = names[j + 1];
                    marks[j] = marks[j + 1];
                }

                count--;

                System.out.println("Student Deleted Successfully.");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }
    }

    static void averageMarks() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += marks[i];
        }

        double average = (double) sum / count;

        System.out.printf("Average Marks: %.2f\n", average);
    }

    static void highestMarks() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        int highest = marks[0];
        int index = 0;

        for (int i = 1; i < count; i++) {

            if (marks[i] > highest) {

                highest = marks[i];
                index = i;
            }
        }

        System.out.println("Highest Marks Student");
        System.out.println("ID : " + ids[index]);
        System.out.println("Name : " + names[index]);
        System.out.println("Marks : " + marks[index]);
    }

    static void lowestMarks() {

        if (count == 0) {
            System.out.println("No Students Available.");
            return;
        }

        int lowest = marks[0];
        int index = 0;

        for (int i = 1; i < count; i++) {

            if (marks[i] < lowest) {

                lowest = marks[i];
                index = i;
            }
        }

        System.out.println("Lowest Marks Student");
        System.out.println("ID : " + ids[index]);
        System.out.println("Name : " + names[index]);
        System.out.println("Marks : " + marks[index]);
    }

    static void totalStudents() {

        System.out.println("Total Students : " + count);
    }
}