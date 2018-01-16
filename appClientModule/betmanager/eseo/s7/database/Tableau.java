package betmanager.eseo.s7.database;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import betmanager.eseo.s7.vue.Dialog;
import betmanager.eseo.s7.vue.DialogInfo;



public class Tableau extends JFrame {
	
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
	
	public List<DialogInfo> selectAll(){
        String sql = "SELECT id, competiteur1, cote1, competiteur2, cote2, mise, choix FROM bets";
        List<DialogInfo> bets = new ArrayList<DialogInfo>();
        
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
        
        return bets;
    }
	
	public Object [][] getData(List<DialogInfo> liste){
		  Object [][] donnees = new Object [liste.size()][7];
		  for(int i = 0, size = liste.size(); i<size;i++){
		   for(DialogInfo inf : liste){
			donnees[i][0] = inf.getId();
		    donnees[i][1] = inf.getCompetiteur1();
		    donnees[i][2] = inf.getCote1();
		    donnees[i][3] = inf.getCompetiteur2();
		    donnees[i][4] = inf.getCote2();
		    donnees[i][5] = inf.getMise();
		    donnees[i][6] = inf.getChoix();
		    
		  }
		  }
		  return donnees;
		}
	
	private JButton bouton = new JButton("Ajouter un pari");

public Tableau(){
	this.setTitle("Ma JFrame");
    this.setSize(300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);      
    this.getContentPane().setLayout(new FlowLayout());
    this.getContentPane().add(bouton);
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        Dialog d = new Dialog(null, "Ajout d'un pari", true);
        DialogInfo info = d.showDialog(); 
//        JOptionPane jop = new JOptionPane();
//        jop.showMessageDialog(null, info.toString(), "Informations", JOptionPane.INFORMATION_MESSAGE);
      }         
    });      
    
  
 
  String[] nomColonne = {"Id", "Competiteur 1", "Cote 1", "Competiteur 2", "Cote 2", "Mise", "Choix",};
  List<DialogInfo> dial = selectAll();
  Object[][] donnees = getData(dial);
    JTable table = new JTable(donnees, nomColonne);
    this.getContentPane().add(new JScrollPane(table));
}   

public static void main(String[] args){
  Tableau tab = new Tableau();
  tab.setVisible(true);
}   
}
