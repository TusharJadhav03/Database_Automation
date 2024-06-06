package DB_Automation;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_CURD_Operation extends DB_Connection{

    @Test
    public void CreateTableTest() throws SQLException {
            con = this.setup();
            Statement stmt = con.createStatement();
            String Query = "CREATE TABLE Students (Roll_no INT AUTO_INCREMENT,Name VARCHAR(50),Mobile_number VARCHAR(10),PRIMARY KEY(Roll_no));";
            stmt.execute(Query);
            System.out.println("Table Created Successfully");
            con.close();
    }

    @Test
    public void InsertDataTest() throws SQLException{
            con = this.setup();
            String Query = "INSERT INTO Student (Roll_no,Name,Mobile_number) VALUES (?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(Query);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"Tushar Jadhav");
            preparedStatement.setString(3,"7845123658");
            preparedStatement.executeUpdate();
            GetDataTest();
    }

    @Test
    public void UpdateDataTest() throws SQLException{
            con = this.setup();
            String Query = "UPDATE Student SET Name = ?,Mobile_number =? WHERE Roll_no = ?";
            PreparedStatement preparedStatement = con.prepareStatement(Query);
            preparedStatement.setString(1,"Sakshi Chavan");
            preparedStatement.setString(2,"8796541452");
            preparedStatement.setInt(3,1);
            preparedStatement.executeUpdate();
            GetDataTest();
    }

    @Test
    public void GetDataTest() throws SQLException{
        con = this.setup();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
        while (rs.next()){
            int Roll_no = rs.getInt(1);
            String Name = rs.getString(2);
            String Mobile_Number = rs.getString(3);
            System.out.println(Roll_no+ " " +Name+ " " +Mobile_Number);
        }
    }

    @Test
    public void DeleteDataTest() throws SQLException{
        con = this.setup();
        String Query = "DELETE FROM Student WHERE Roll_no = ?";
        PreparedStatement preparedStatement = con.prepareStatement(Query);
        preparedStatement.setInt(1,2);
        preparedStatement.executeUpdate();
        GetDataTest();
    }
}
