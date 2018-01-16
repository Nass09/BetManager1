package betmanager.eseo.s7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp {
 
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the bets table
     *
     * @param competiteur1
     * @param cote1
     * @param competiteur2
     * @param cote2
     * @param mise
     * @param choix
     */
    public void insert(int id, String competiteur1, double cote1, String competiteur2, double cote2, double mise, String choix) {
        String sql = "INSERT INTO bets(id, competiteur1,cote1,competiteur2,cote2,mise,choix) VALUES(?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, id);
            pstmt.setString(2, competiteur1);
            pstmt.setDouble(3, cote1);
            pstmt.setString(4, competiteur2);
            pstmt.setDouble(5, cote2);
            pstmt.setDouble(6, mise);
            pstmt.setString(7, choix);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert(1,"Manchester", 1.2, "Liverpool", 2.2, 220, "Liverpool");
       
    }
 
}
