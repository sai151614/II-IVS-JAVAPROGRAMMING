
import java.sql.*;

public class StudentDAO {

    public void addStudent(String name, String dept, String phone)
    {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO students(name,department,phone) VALUES(?,?,?)");

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setString(3, phone);
            ps.executeUpdate();

            System.out.println("Student Added");

        } catch (Exception e) 
          { e.printStackTrace(); }
    }
//----------------------------------------------------------------------------------------------------------

    public void viewStudents() {
        try (Connection con = DBConnection.getConnection()) 
   {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " "+ rs.getString("name"));
            }

        } catch (Exception e) 
         { e.printStackTrace(); }
    }
}