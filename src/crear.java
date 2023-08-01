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
    private JTextField idfile;
    private JTextField nombrefile;
    private JTextField edadfile;
    private JTextField ciudadfile;
    static final String DB_URL = "jdbc:mysql://localhost/poo";
    static final String USER = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "Select * From Estudiantes";
    public crear(){
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(idfile.getText());
                String nombreS = nombrefile.getText();
                int nombre = Integer.parseInt(nombreS);
                int edad=Integer.parseInt(edadfile.getText());
                String ciudadS = nombrefile.getText();
                int ciudad = Integer.parseInt(ciudadS);
                int cedula=Integer.parseInt(cedulafile.getText());
                String query= "insert into Estudiantes values ("+id+",'"+nombre+"',"+edad+",'"+ciudad+"',"+cedula;
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