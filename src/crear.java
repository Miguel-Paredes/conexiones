import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class crear {
    JPanel rootPanel;
    private JButton crearButton;
    private JTextField cedulafile;
    static final String DB_URL = "jdbc:mysql://localhost/poo";
    static final String USER = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "Select * From Estudiantes";
    public crear(){
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula=Integer.parseInt(cedulafile.getText());
                String query= "insert into Estudiantes ('cedula') values  cedula= "+cedula;
                try(
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt= conn.createStatement();
                ){
                    stmt.executeUpdate(query);
                }catch (SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}