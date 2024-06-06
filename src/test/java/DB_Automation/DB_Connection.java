package DB_Automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    Connection con = null;

    @BeforeClass
    public Connection setup() {
        try {
            String url = "jdbc:mysql://localhost:3306/database_automation";
            String username = "root";
            String password = "1999";
            con = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("Connection Successfully");
        return con;
    }

    @AfterClass
    public void tearDown() throws SQLException{
        con.close();
    }
}
