
import java.util.*;
import java.sql.*;

public class BookDAO {

    public void addBook(String title, String author, int quantity) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "insert into books(title,author,quantity,available_quantity) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.setInt(4, quantity);
            ps.executeUpdate();

            System.out.println("Book Added Successfully");

        } catch (Exception e)
         { e.printStackTrace(); }
    }
  //------------------------------------------------------------------------------------------------------

    public void viewAllBooks() {
        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.createStatement().executeQuery("select * FROM books");

            while (rs.next())
           {
                System.out.println(rs.getInt("book_id") + " "+ rs.getString("title") + " " + rs.getInt("available_quantity"));
            }

        } catch (Exception e) 
          { e.printStackTrace(); }
    }
//----------------------------------------------------------------------------------------------------------

   public void deleteBook(int id) {

    try (Connection con = DBConnection.getConnection()) {

        // Check if the book is issued
        PreparedStatement check =
        con.prepareStatement("SELECT * FROM issues WHERE book_id=?");
        check.setInt(1, id);

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            System.out.println("Book is currently issued. Cannot delete.");
            return;
            
        }

        // Delete the book
        PreparedStatement ps =
        con.prepareStatement("DELETE FROM books WHERE book_id=?");

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book Deleted Successfully");
        } else {
            System.out.println("Book ID not found");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
//------------------------------------------------------------------------------------------------------

    public void updateBook(int id, String title, String author, int quantity) {
        try (Connection con = DBConnection.getConnection())
       {

            PreparedStatement ps = con.prepareStatement("UPDATE books SET title=?, author=?, quantity=?, available_quantity=? WHERE book_id=?");

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.setInt(4, quantity);
            ps.setInt(5, id);
            ps.executeUpdate();

            System.out.println("Book Updated");

        } catch (Exception e) 
          { e.printStackTrace(); }
    }
}