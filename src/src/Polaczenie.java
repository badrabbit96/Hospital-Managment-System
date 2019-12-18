
import java.sql.*;
import javax.swing.*;
public class Polaczenie {
     Connection con=null;
     
        public static Connection ConnectDB(){
             try{     
         Class.forName("oracle.jdbc.OracleDriver");
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
         return con;           
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
}
}
