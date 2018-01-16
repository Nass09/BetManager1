package betmanager.eseo.s7.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class NewTable {
 
    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS bets (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	competiteur1 text NOT NULL,\n"
                + "	cote1 real NOT NULL,\n"
                + "	competiteur2 text NOT NULL,\n"
                + "	cote2 real NOT NULL,\n"
                + "	mise real NOT NULL,\n"
                + "	choix text NOT NULL \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
 
}
