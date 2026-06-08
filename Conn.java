import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;
    
    public Conn() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank_system_db", "postgres", "Lucky@16");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
