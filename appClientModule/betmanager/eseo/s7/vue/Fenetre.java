package betmanager.eseo.s7.vue;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame {
	
	private JButton bouton = new JButton("Ajouter un pari");

	public Fenetre(){      
	    this.setTitle("Ma JFrame");
	    this.setSize(300, 100);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);      
	    this.getContentPane().setLayout(new FlowLayout());
	    this.getContentPane().add(bouton);
	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        Dialog zd = new Dialog(null, "Coucou les ZérOs", true);
	        DialogInfo info = zd.showDialog(); 
	        JOptionPane jop = new JOptionPane();
	        jop.showMessageDialog(null, info.toString(), "Informations", JOptionPane.INFORMATION_MESSAGE);
	      }         
	    });      
	    this.setVisible(true);      
	  }
}
