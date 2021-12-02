import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:moviesdb.db";

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE movies (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " MovieName TEXT NOT NULL,\n"
                + " Actor TEXT NOT NULL,\n"
                + " Actress TEXT NOT NULL,\n"
                + " Director TEXT NOT NULL,\n"
                + " ReleaseYear INTEGER NOT NULL\n"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Movies Table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        createNewTable();
    }

}  