import java.sql.*;
public class miprimerSelect {
    static final String DB_URL = "jdbc:mysql://localhost/poo";
    static final String USER = "root";
    static final String PASS = "un_password_cualquiera";
    static final String QUERY = "SELECT * FROM ESTUDIANES";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
        ) {while(rs.next()){
            System.out.println("id: "+rs.getInt("id"));
            System.out.println("nombre: "+rs.getString("nombre"));
            System.out.println("edad: "+rs.getInt("edad"));
            System.out.println("ciudad: "+rs.getString("ciudad"));
            System.out.println("cedula: "+rs.getInt("cédula"));
            System.out.println("password: "+rs.getInt("password"));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}