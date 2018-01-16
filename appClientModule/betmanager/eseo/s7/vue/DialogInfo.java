package betmanager.eseo.s7.vue;

public class DialogInfo {
	
	  private int id;
	
	  private String competiteur1, competiteur2, choix;
	  
	  private double cote1, cote2, mise;

	  public DialogInfo(){}
	  
	  public DialogInfo(int id, String competiteur1, double cote1, String competiteur2, double cote2, 
			  double mise, String choix){
		this.id = id;
	    this.competiteur1 = competiteur1;
	    this.cote1 = cote1;
	    this.competiteur2 = competiteur2;
	    this.cote2 = cote2;
	    this.mise = mise;
	    this.choix = choix;
	  }
	  
	  public int getId() {
		  return this.id;
	  }
	  
	  public String getCompetiteur1() {
		  return this.competiteur1;
	  }
	  
	  public double getCote1() {
		  return this.cote1;
	  }
	  
	  public String getCompetiteur2() {
		  return this.competiteur2;
	  }
	  
	  public double getCote2() {
		  return this.cote2;
	  }
	  
	  public double getMise() {
		  return this.mise;
	  }
	  
	  public String getChoix() {
		  return this.choix;
	  }
	  
	  public void setId(int id) {
		  this.id = id;
	  }
	  
	  public void setCompetiteur1(String competiteur1) {
		  this.competiteur1 = competiteur1;
	  }
	  
	  public void setCote1(double cote1) {
		  this.cote1 = cote1;
	  }
	  
	  public void setCompetiteur2(String competiteur2) {
		  this.competiteur2 = competiteur2;
	  }
	  
	  public void setCote2(double cote2) {
		  this.cote2 = cote2;
	  }
	  
	  public void setMise(double mise) {
		  this.mise = mise;
	  }
	  
	  public void setChoix(String choix) {
		  this.choix = choix;
	  }

	  public String toString(){
	    String str;
	    if(this.competiteur1 != null && this.cote1 != 0 && this.competiteur2 != null && this.cote2 != 0 && this.mise != 0 && this.choix != null){
	      str = "Description du paris";
	      str += "Competiteur 1 : " + this.competiteur1 + "\n";
	      str += "Cote du competiteur 1 : " + String.valueOf(this.cote1) + "\n";
	      str += "Competiteur 2 : " + this.competiteur2 + "\n";
	      str += "Cote du competiteur 2 : " + String.valueOf(this.cote2) + "\n";
	      str += "Mise : " + String.valueOf(this.mise) + "\n";
	      str += "Choix : " + this.choix + "\n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}
