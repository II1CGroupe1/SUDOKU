package sudoku;

public class Region {
	public Case[][] region;
	
	//Constructeur par défaut
	public Region(){
		region = new Case[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				region[i][j] = new Case();
				}
			}
		}
	
	//Accéder à la case de coordonnées i et j
	public Case getCase(int i, int j){
		return region[i][j];
		}
	
	//Accéder à la valeur d'une case de coordonnées i et j
		public int getCaseVal(int i, int j){
			return region[i][j].getValeur();
			}
		
	//Accéder à l'état d'une case de coordonnées i et j
			public boolean getCaseFixe(int i, int j){
				return region[i][j].getFixe();
				}
	
	//Modifier la valeur d'une case de coordnnées i et j
	public void setCaseVal(int i, int j, int c){
		(region[i][j]).setValeur(c);
		}
	
	//Modifier l'état d'une case de coordnnées i et j
		public void setCaseFixe(int i, int j, boolean f){
			(region[i][j]).setFixe(f);
			}
	
	//Vérifier si la région est complète
		public  boolean verifRegion() {
			boolean un = false;
			boolean deux = false;
			boolean trois = false;
			boolean quatre = false;
			boolean cinq = false;
			boolean six = false;
			boolean sept = false;
			boolean huit = false;
			boolean neuf = false;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					switch((region[i][j]).getValeur())
					{
					case 1 : un = true; 
					break;
					case 2 : deux = true;
					break;
					case 3 : trois = true;
					break;
					case 4 : quatre = true; 
					break; 
					case 5 : cinq = true; 
					break;
					case 6 : six = true; 
					break;
					case 7 : sept = true; 
					break;
					case 8 : huit = true; 
					break;
					case 9 : neuf = true; 
					break;
					}
					}
				}
			if(un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
				return true;} else return false;
		}
		
								
}


