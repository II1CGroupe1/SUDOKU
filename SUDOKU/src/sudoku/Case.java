package sudoku;

public class Case {
	
	int x ;
	int y ;
	boolean fixe ;
	int val ;
	
	//Constructeur par d�faut
	public Case() {
		val=0;
		fixe=false;
	}
	//Constructeur avec param�tres
	public Case(int val, boolean f) {
		this.val=val;
		this.fixe=f;
	}
	
	//Acc�der � la ligne o� se trouve la case
	public int getligne() {
		return x ;
	}
	
	//Acc�der � la colonne o� se trouve la case
	public int getcolonne() {
		return y ;
	}
	
	//Modifier la ligne o� se trouve la case
	public void setligne(int x) {
		this.x=x;
	}
	
	//Modifier la colonne o� se trouve la case
	public void setcolonne(int y) {
		this.y=y;
	}
	
	//Acc�der � l'�tat de la case
	public boolean getFixe() {
		return fixe;
	}
	//Acc�der � la valeur de la case
		public int getValeur() {
			return val;}
	
	//Modifier l'�tat de la case
	public void setFixe(boolean fixe) {
		this.fixe=fixe;
	}
	
	//Modifier la valeur de la case
	public void setValeur(int x) {
		this.val=x;
	}
	
	
	
	
	
}

