import java.sql.*;

public class UserDAO {

    //  Register User

    public void register(String username, String password, String role) 
  {

        try (Connection con = DBConnection.getConnection()) 
      {

            String sql = "INSERT INTO users(username,password,role) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password); 
            ps.setString(3, role);

            ps.executeUpdate();
            System.out.println("Registration Successful!");

        }
            catch (SQLIntegrityConstraintViolationException e)
        {
            System.out.println("Username already exists!");
        } 
           catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Login User

    public String login(String username, String password) {

    try (Connection con = DBConnection.getConnection()) {

        String sql = "SELECT role FROM users WHERE username=? AND password=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("role");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}