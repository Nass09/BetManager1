package betmanager.eseo.s7.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import betmanager.eseo.s7.vue.DialogInfo;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {
 
    /**
     * Connect to the test.db database
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
     * select all rows in the bets table
     */
    public void selectAll(){
        String sql = "SELECT id, competiteur1, cote1, competiteur2, cote2, mise, choix FROM bets";
        ArrayList<DialogInfo> bets = new ArrayList();
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("competiteur1") + "\t" +
                                   rs.getDouble("cote1") + "\t" +
                                   rs.getString("competiteur2") + "\t" +
                                   rs.getDouble("cote2") + "\t" +
                                   rs.getDouble("mise") + "\t" +
                                   rs.getString("choix")
                                   );
                
//                bets.add(rs.getInt("id") +  ", " + 
//                                   rs.getString("competiteur1") + ", " +
//                                   rs.getDouble("cote1") + ", " +
//                                   rs.getString("competiteur2") + ", " +
//                                   rs.getDouble("cote2") + ", " +
//                                   rs.getDouble("mise") + ", " +
//                                   rs.getString("choix"));
                
                DialogInfo inf = new DialogInfo();
                
                inf.setId(rs.getInt("id"));
                inf.setCompetiteur1(rs.getString("competiteur1"));
                inf.setCote1(rs.getDouble("cote1"));
                inf.setCompetiteur2(rs.getString("competiteur2"));
                inf.setCote2(rs.getDouble("cote2"));
                inf.setMise(rs.getDouble("mise"));
                inf.setChoix(rs.getString("choix"));
                
                bets.add(inf);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }
 
}
