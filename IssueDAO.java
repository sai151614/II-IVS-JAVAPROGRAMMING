import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IssueDAO {

    // Issue Book
    public void issueBook(int studentId, int bookId) {

        try (Connection con = DBConnection.getConnection()) {

            // Check if book exists
            PreparedStatement checkBook = con.prepareStatement(
                    "SELECT available_quantity FROM books WHERE book_id=?");
            checkBook.setInt(1, bookId);

            ResultSet rs = checkBook.executeQuery();

            if (rs.next()) {

                int quantity = rs.getInt("available_quantity");

                if (quantity > 0) {

                    // Check if student exists
                    PreparedStatement checkStudent = con.prepareStatement(
                            "SELECT student_id FROM students WHERE student_id=?");
                    checkStudent.setInt(1, studentId);

                    ResultSet studentRs = checkStudent.executeQuery();

                    if (!studentRs.next()) {
                        System.out.println("Student ID does not exist");
                        return;
                    }

                    // Insert issue record
                    PreparedStatement issue = con.prepareStatement(
                            "INSERT INTO issues(student_id,book_id,issue_date,fine) VALUES(?,?,CURDATE(),0)");

                    issue.setInt(1, studentId);
                    issue.setInt(2, bookId);
                    issue.executeUpdate();

                    // Decrease book quantity
                    PreparedStatement updateBook = con.prepareStatement(
                            "UPDATE books SET available_quantity = available_quantity - 1 WHERE book_id=?");

                    updateBook.setInt(1, bookId);
                    updateBook.executeUpdate();

                    System.out.println("Book Issued Successfully");

                } else {
                    System.out.println("Book is Out of Stock");
                }

            } else {
                System.out.println("Book ID does not exist");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return Book
    public void returnBook(int issueId) {

        try (Connection con = DBConnection.getConnection()) {

            // Get issue details
            PreparedStatement ps = con.prepareStatement(
                    "SELECT book_id, issue_date FROM issues WHERE issue_id=?");
            ps.setInt(1, issueId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int bookId = rs.getInt("book_id");

                LocalDate issueDate = rs.getDate("issue_date").toLocalDate();
                LocalDate today = LocalDate.now();

                long days = ChronoUnit.DAYS.between(issueDate, today);

                double fine = (days > 7) ? (days - 7) * 5 : 0;

                // Increase book quantity
                PreparedStatement updateBook = con.prepareStatement(
                        "UPDATE books SET available_quantity = available_quantity + 1 WHERE book_id=?");

                updateBook.setInt(1, bookId);
                updateBook.executeUpdate();

                // Delete issue record
                PreparedStatement deleteIssue = con.prepareStatement(
                        "DELETE FROM issues WHERE issue_id=?");

                deleteIssue.setInt(1, issueId);
                deleteIssue.executeUpdate();

                System.out.println("Book Returned Successfully");
                System.out.println("Fine: " + fine);

            } else {
                System.out.println("Invalid Issue ID!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}