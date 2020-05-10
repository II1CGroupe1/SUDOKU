package sudoku;

public class Case {
	
	int x ;
	int y ;
	boolean fixe ;
	int val ;
	
	//Constructeur par défaut
	public Case() {
		val=0;
		fixe=false;
	}
	//Constructeur avec paramètres
	public Case(int val, boolean f) {
		this.val=val;
		this.fixe=f;
	}
	
	//Accéder à la ligne où se trouve la case
	public int getligne() {
		return x ;
	}
	
	//Accéder à la colonne où se trouve la case
	public int getcolonne() {
		return y ;
	}
	
	//Modifier la ligne où se trouve la case
	public void setligne(int x) {
		this.x=x;
	}
	
	//Modifier la colonne où se trouve la case
	public void setcolonne(int y) {
		this.y=y;
	}
	
	//Accéder à l'état de la case
	public boolean getFixe() {
		return fixe;
	}
	//Accéder à la valeur de la case
		public int getValeur() {
			return val;}
	
	//Modifier l'état de la case
	public void setFixe(boolean fixe) {
		this.fixe=fixe;
	}
	
	//Modifier la valeur de la case
	public void setValeur(int x) {
		this.val=x;
	}
	
	
	
	
	
}

