package betmanager.eseo.s7.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import betmanager.eseo.s7.database.InsertApp;

public class Dialog extends JDialog {
	
	private DialogInfo info = new DialogInfo();
	  private boolean sendData;
	  private JLabel competiteur1Label, competiteur2Label, cote1Label, cote2Label, miseLabel, choixLabel;
	  private JTextField competiteur1, competiteur2, choix;
	  private JFormattedTextField cote1, cote2, mise;
	  
	  public Dialog(JFrame parent, String title, boolean modal){
		    super(parent, title, modal);
		    this.setSize(550, 270);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		    this.initComponent();
		  }

	 public DialogInfo showDialog(){
		    this.sendData = false;
		    this.setVisible(true);      
		    return this.info;      
		  }
	 
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
	 
	 private void initComponent(){
		 
		    JPanel panCompetiteur1 = new JPanel();
		    panCompetiteur1.setBackground(Color.white);
		    panCompetiteur1.setPreferredSize(new Dimension(220, 60));
		    competiteur1 = new JTextField();
		    competiteur1.setPreferredSize(new Dimension(100, 25));
		    panCompetiteur1.setBorder(BorderFactory.createTitledBorder("Competiteur 1"));
		    competiteur1Label = new JLabel("Saisir le competiteur 1 :");
		    panCompetiteur1.add(competiteur1Label);
		    panCompetiteur1.add(competiteur1);
		    
		    
		    
		    JPanel panCompetiteur2 = new JPanel();
		    panCompetiteur2.setBackground(Color.white);
		    panCompetiteur2.setPreferredSize(new Dimension(220, 60));
		    competiteur2 = new JTextField();
		    competiteur2.setPreferredSize(new Dimension(100, 25));
		    panCompetiteur2.setBorder(BorderFactory.createTitledBorder("Competiteur 2"));
		    competiteur2Label = new JLabel("Saisir le competiteur 2 :");
		    panCompetiteur2.add(competiteur2Label);
		    panCompetiteur2.add(competiteur2);
		    
		    
		    JPanel panCote1 = new JPanel();
		    panCote1.setBackground(Color.white);
		    panCote1.setPreferredSize(new Dimension(220, 60));
		    cote1 = new JFormattedTextField();
		    cote1.setPreferredSize(new Dimension(100, 25));
		    panCote1.setBorder(BorderFactory.createTitledBorder("Cote 1"));
		    cote1Label = new JLabel("Saisir la cote du competiteur 1 :");
		    panCote1.add(cote1Label);
		    panCote1.add(cote1);
		    
		    
		    JPanel panCote2 = new JPanel();
		    panCote2.setBackground(Color.white);
		    panCote2.setPreferredSize(new Dimension(220, 60));
		    cote2 = new JFormattedTextField();
		    cote2.setPreferredSize(new Dimension(100, 25));
		    panCote2.setBorder(BorderFactory.createTitledBorder("Cote 2"));
		    cote2Label = new JLabel("Saisir la cote du competiteur 2 :");
		    panCote2.add(cote2Label);
		    panCote2.add(cote2);
		    
		    JPanel panMise = new JPanel();
		    panMise.setBackground(Color.white);
		    panMise.setPreferredSize(new Dimension(220, 60));
		    mise = new JFormattedTextField();
		    mise.setPreferredSize(new Dimension(100, 25));
		    panMise.setBorder(BorderFactory.createTitledBorder("Mise"));
		    miseLabel = new JLabel("Saisir la mise :");
		    panMise.add(miseLabel);
		    panMise.add(mise);
		    
		    JPanel panChoix = new JPanel();
		    panChoix.setBackground(Color.white);
		    panChoix.setPreferredSize(new Dimension(220, 60));
		    choix = new JTextField();
		    choix.setPreferredSize(new Dimension(100, 25));
		    panChoix.setBorder(BorderFactory.createTitledBorder("Choix du competiteur vainqueur"));
		    choixLabel = new JLabel("Choisir le competiteur sur lequel miser :");
		    panChoix.add(choixLabel);
		    panChoix.add(choix);
		    
		    JPanel content = new JPanel();
		    content.setBackground(Color.white);
		    content.add(panCompetiteur1);
		    content.add(panCompetiteur2);
		    content.add(panCote1);
		    content.add(panCote2);
		    content.add(panMise);
		    content.add(panChoix);

		    JPanel control = new JPanel();
		    JButton okBouton = new JButton("OK");
		    
		    
		    
		    okBouton.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {        
//		        info = new DialogInfo(1, competiteur1.getText(), Double.parseDouble(cote1.getText()), competiteur2.getText(), Double.parseDouble(cote2.getText()), Double.parseDouble(mise.getText()), choix.getText());
		        InsertApp app = new InsertApp();
		        app.insert(3, competiteur1.getText(), Double.parseDouble(cote1.getText()), competiteur2.getText(), Double.parseDouble(cote2.getText()), Double.parseDouble(mise.getText()), choix.getText());
		        setVisible(false);
		      }
		    
		    });
		    
		    JButton cancelBouton = new JButton("Annuler");
		    cancelBouton.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        setVisible(false);
		      }      
		    });

		    control.add(okBouton);
		    control.add(cancelBouton);
		    
		    this.getContentPane().add(content, BorderLayout.CENTER);
		    this.getContentPane().add(control, BorderLayout.SOUTH);
	 
}
};
