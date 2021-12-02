import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class queryingInDB {

    private Connection connect() {
        String url = "jdbc:sqlite:moviesdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectAll(){
        //a simple SELECT statement to query all rows from the Movies table,
        String sql = "SELECT * FROM movies";
        //select movies based on the actor's name.
        String sql2 = "SELECT * FROM movies WHERE Actor = 'Shahrukh Khan'";

        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            ResultSet rs2   = stmt.executeQuery(sql2);

            // loop through the result set  
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("MovieName") + "\t" +
                        rs.getString("Actor") + "\t" +
                        rs.getString("Actress") + "\t" +
                        rs.getString("Director") + "\t" +
                        rs.getInt("ReleaseYear") + "\t");
            }
            //loop through the result set
            while (rs2.next()) {
                System.out.println(rs2.getInt("id") +  "\t" +
                        rs2.getString("MovieName") + "\t" +
                        rs2.getString("Actor") + "\t" +
                        rs2.getString("Actress") + "\t" +
                        rs2.getString("Director") + "\t" +
                        rs2.getInt("ReleaseYear") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void selectMovie(){
        //a simple SELECT statement to query all rows from the Movies table,
        String sql = "SELECT * FROM movies WHERE MovieName = 'Titanic'";

        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            //show the result set only the movie which is selected

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("MovieName") + "\t" +
                        rs.getString("Actor") + "\t" +
                        rs.getString("Actress") + "\t" +
                        rs.getString("Director") + "\t" +
                        rs.getInt("ReleaseYear") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        queryingInDB app = new queryingInDB();
        app.selectAll();
        app.selectMovie();
    }

}