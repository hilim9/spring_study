package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "scott";
        String password = "tiger";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
             int deptNo = 50;
             String dName = "DEPT1";
             String loc = "LOC1";
             //String sql = "INSERT INTO DEPT2 VALUES (50,'DEPT1','LOC1')";
             String sql = "INSERT INTO DEPT2 VALUES (" + deptNo + ", '" + dName + "', '" + loc + "')";
             int affectedRows = stmt.executeUpdate(sql);

             System.out.println(affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
