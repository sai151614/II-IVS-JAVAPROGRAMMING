import java.sql.*;
import java.util.Scanner;

public class LibrarySystem {

    static Scanner sc = new Scanner(System.in);
    static UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {

        // STEP 1: Check Database Connection

        try (Connection con = DBConnection.getConnection()) {

            if (con != null) {
                System.out.println("Database Connected Successfully");
            } else {
                System.out.println("Database Connection Failed");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // STEP 2: Main Menu Loop
        while (true) {

            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    loginUser();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // ================= REGISTER =================

    public static void registerUser() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Role (ADMIN/STUDENT): ");
        String role = sc.nextLine().toUpperCase();

        userDAO.register(username, password, role);
    }

    // ================= LOGIN =================

    public static void loginUser() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String role = userDAO.login(username, password);

        if (role == null) {
            System.out.println("Invalid Username or Password");
        } 
        else if (role.equals("ADMIN")) {
            adminMenu();
        } 
        else 
        {
            studentMenu();
        }
    }

    // ================= ADMIN MENU =================
    public static void adminMenu() {

        BookDAO bookDAO = new BookDAO();
        StudentDAO studentDAO = new StudentDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Update Book");
            System.out.println("7. Delete Book");
            System.out.println("8. View Students");
            System.out.println("9. Logout");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    bookDAO.addBook(title, author, qty);
                    break;

                case 2:
                    bookDAO.viewAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department Name: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    studentDAO.addStudent(name, dept, phone);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    issueDAO.issueBook(sid, bid);
                    break;

                case 5:
                    System.out.print("Enter Issue ID: ");
                    int iid = sc.nextInt();
                    sc.nextLine();

                    issueDAO.returnBook(iid);
                    break;

                case 6:
                    System.out.print("Enter Book ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author Name: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    sc.nextLine();

                    bookDAO.updateBook(uid, newTitle, newAuthor, newQty);
                    break;

                case 7:
                    System.out.print("Enter Book ID to Delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine();

                    bookDAO.deleteBook(delId);
                    break;

                case 8:
                    studentDAO.viewStudents();
                    break;

                case 9:
                    return; // Logout

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // ================= STUDENT MENU =================
    public static void studentMenu() {

        BookDAO bookDAO = new BookDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Return Book");
            System.out.println("3. Logout");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    bookDAO.viewAllBooks();
                    break;

                case 2:
                    System.out.print("Enter Issue ID: ");
                    int iid = sc.nextInt();
                    sc.nextLine();

                    issueDAO.returnBook(iid);
                    break;

                case 3:
                    return; // Logout

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}