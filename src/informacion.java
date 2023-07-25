import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class informacion {
    static final String DB_URL = "jdbc:mysql://localhost/poo";
    static final String USER = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "Select * From Estudiantes";
    private JLabel idr;
    private JLabel nombrer;
    private JLabel edadr;
    private JLabel ciudadr;
    private JLabel cedular;
    private JLabel contraseniar;
    private JButton query;
    private javax.swing.JPanel JPanel;

    public informacion() {
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(QUERY);
                ) {while(rs.next()){
                    idr.setText("id: "+rs.getInt("id"));
                    nombrer.setText("nombre: "+rs.getString("nombre"));
                    edadr.setText("edad: "+rs.getInt("edad"));
                    ciudadr.setText("ciudad: "+rs.getString("ciudad"));
                    cedular.setText("cedula: "+rs.getString("cédula"));
                    contraseniar.setText("password: "+rs.getString("password"));
                }
                } catch (SQLException a) {
                    throw new RuntimeException(a);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("informacion");
        frame.setContentPane(new informacion().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(200,200);
    }
}
