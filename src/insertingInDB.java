
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertingInDB {

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


    public void insert(String MovieName, String Actor, String Actress, String Director, int ReleaseYear) {
        String sql = "INSERT INTO movies(MovieName, Actor, Actress, Director, ReleaseYear) VALUES(?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, MovieName);
            pstmt.setString(2, Actor);
            pstmt.setString(3, Actress);
            pstmt.setString(4, Director);
            pstmt.setInt(5, ReleaseYear);
            pstmt.executeUpdate();
            System.out.println("Inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        insertingInDB app = new insertingInDB();
        // insert data
        app.insert("My Name is Khan", "Shahrukh Khan", "Kajol", "Karan Johar", 2011);
        app.insert("Titanic", "Leonardo DiCaprio", "Kate Winslet", "James Cameron", 1997);
        app.insert("The Avengers", "Robert Downey Jr.", "Scarlett Johansson", "Joss Whedon", 2012);
        app.insert("Avatar", "Sam Worthington", "Zoe Saldana", "James Cameron", 2009);
    }

}
