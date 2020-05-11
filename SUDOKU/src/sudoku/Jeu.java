package sudoku;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;



public class Jeu {
	
	public Region[][] grille;
	String tableauFich[] = {"C:/Users/asus/Desktop/ENSI/2ème Semestre/POO/Java/SUDOKU/fichier.txt","C:/Users/asus/Desktop/ENSI/2ème Semestre/POO/Java/SUDOKU/fichier2.txt","C:/Users/asus/Desktop/ENSI/2ème Semestre/POO/Java/SUDOKU/fichier3.txt","C:/Users/asus/Desktop/ENSI/2ème Semestre/POO/Java/SUDOKU/fichier4.txt"};
	Random rand = new Random();
	int r=rand.nextInt(4);
	
	public Jeu() {
		
		grille = new Region[3][3];
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				grille[i][j]=new Region();
			}
		}
	}
	
	
	
	
	//Accéder à une Région
	public Region getRegion(int i, int j) {
		return grille[i][j];
	}
	//Accéder à la région où se trouve la case de coordonnées i et j
	public Region getCaseDansRegion(int i, int j) {
		return grille[(int)(i/3)][(int)(j/3)];
	}
	//Accéder à la valeur de la case de coordonnées i et j
	public int getValCase(int i , int j) {
		return grille[(int)(i/3)][(int)(j/3)].getCaseVal(i%3,j%3);
	}
	//Accéder à l'état d'une case
	public boolean getEtatCase(int i, int j) {
		return grille[(int)(i/3)][(int)(j/3)].getCaseFixe(i%3,j%3);
	}
	
	//Modifier la grille
	public void setRegion(Region[][] r){
		grille = r;}
	//Modifier la valeur de la case dans la grille
	public void setValCase(int i, int j, int x) {
		grille[(int)(i/3)][(int)(j/3)].setCaseVal(i%3,j%3,x);
	}
	//Modifier l'etat d'une case
	public void setEtatCase(int i, int j, boolean x) {
		grille[(int)(i/3)][(int)(j/3)].setCaseFixe(i%3,j%3,x);
	}
	
	
	//Vérifier la ligne num i
	public boolean verifLigne(int i) {
		//On vérifie si la ligne ne contient que des chiffres de 1 à 9
		boolean chiffre = false;
		
		boolean un = false;
		boolean deux = false;
		boolean trois = false;
		boolean quatre = false;
		boolean cinq = false;
		boolean six = false;
		boolean sept = false;
		boolean huit = false;
		boolean neuf = false;
		for(int j=0;j<9;j++){
			switch(this.getValCase(i,j)){
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
			break;}}
		if(un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
			chiffre=true;
		}
		//On vérifie si la ligne respecte la contrainte
		int valeur;
		int j=0;
		if (chiffre) {
			while (j<9) {
			valeur=this.getValCase(i, j);
			if(valeur!=0){
				for(int k=0;k<9;k++){
					if(k!=j) {
						if(valeur == this.getValCase(i,k)) {
							return false;}}
				j++;
			}
		}
	  }return true;
	}else {return false;}
	}
	
	//Vérifier la colonne num j
		public boolean verifColonne(int j) {
			//On vérifie si la colonne ne contient que des chiffres de 1 à 9
			boolean chiffre = false;
			
			boolean un = false;
			boolean deux = false;
			boolean trois = false;
			boolean quatre = false;
			boolean cinq = false;
			boolean six = false;
			boolean sept = false;
			boolean huit = false;
			boolean neuf = false;
			for(int i=0;i<9;i++){
				switch(this.getValCase(i,j)){
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
				break;}}
			if(un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
				chiffre=true;
			}
			//On vérifie si la colonne respecte la contrainte
			int valeur;
			int i=0;
			if (chiffre) {
				while (i<9) {
				valeur=this.getValCase(i, j);
				if(valeur!=0){
					for(int k=0;k<9;k++){
						if(k!=i) {
							if(valeur == this.getValCase(k,j)) {
								return false;}}
					i++;
				}
			}
		  }return true;
		}else {return false;}
		}
	
	//On vérifie si le joueur a gagné
		public boolean gagne(){
			for (int i=0;i<3;i++) {
				for (int j=0;j<3;j++) {
					if(!(grille[i][j]).verifRegion()) {
						return false;}
				}
			}
			for (int i=0;i<9;i++) {
				if(!verifColonne(i) || !verifLigne(i)) {
					return false;}
			}
			return true;
				}
					
				
		
	//Remplir la grille selon le niveau et à partir d'un fichier
	public void remplirAlea(int niveau ) throws NumberFormatException, IOException {
		
		int table[] = new int[81];
		
		int tab1[] = {0,1,1,1,1,1,0,1,0,0,0,1,1,0,1,0,1,1,0,0,0,0,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,0,1,1,0,1,1,0,0,1,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,1,0,1,0,1,1,0,0,0,1,0,1,1,1,1,1,0};
		int tab2[] = {0,0,0,1,1,0,1,0,0,0,0,0,1,0,1,0,1,1,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,1,0,0,0,1,1,0,0,1,0,1,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,0,1,1,0,0,0};
		int tab3[] = {0,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0,0,0,1,0};
		int tab4[] = {0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,1,0,1,1,0,0,1,0,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,1,1,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0,1,0,1,0,0,1,0};
		
		int tabfinal1[] = new int[81];
		int tabfinal2[] = new int[81];
		int tabfinal3[] = new int[81];
		int tabfinal4[] = new int[81];
		
		
		//Lire les éléments d'une grille à partir d'un fichier et les insérer dans un tableau
		BufferedReader Lecteur = null;
		try {
			
			Lecteur = new BufferedReader(new FileReader(tableauFich[r]));
 
           String ligne; 
	       int index = 0; 
	       while ((ligne = Lecteur.readLine()) != null) {
	    	   table[index]=Integer.parseInt(ligne);
	    	   index++;
		       }
                       
		}
		catch(FileNotFoundException exc) {
			System.out.println("erreur");
			 exc.printStackTrace(); 
		}
		finally {
            if ( Lecteur!=null ) {
         try {
                 Lecteur.close();
                 } catch( IOException exc) {
	           System.out.println("Fichier mal fermé");
                         exc.printStackTrace(); 
                 }
            }
      }
		//A partir du tableau table on va générer d'autres tableaux où certaines cases seront masquées
		for(int i=0;i<81;i++) {
			tabfinal1[i]=tab1[i]*table[i];
		    tabfinal2[i]=tab2[i]*table[i];
		    tabfinal3[i]=tab3[i]*table[i];
		    tabfinal4[i]=tab4[i]*table[i];
		}
		
				//On va générer des grilles selon le niveau de difficultés
				switch(niveau) {
				case 1:
					for (int indX=0; indX<9;indX++) {
						for (int indY=0; indY<9;indY++) {
							this.setValCase(indX,indY,tabfinal1[indX+9*indY]);
							if (this.getValCase(indX,indY)==0) {
								this.setEtatCase(indX, indY, false);
								
							}else {this.setEtatCase(indX, indY, true);}
						}}
					break;
				case 2:
					for (int indX=0; indX<9;indX++) {
						for (int indY=0; indY<9;indY++) {
							this.setValCase(indX,indY,tabfinal2[indX+9*indY]);
							if (this.getValCase(indX,indY)==0) {
								this.setEtatCase(indX, indY, false);
							}else {this.setEtatCase(indX, indY, true);}
					 }}
					break;
				case 3:
					for (int indX=0; indX<9;indX++) {
						for (int indY=0; indY<9;indY++) {
							this.setValCase(indX,indY,tabfinal3[indX+9*indY]);
							if (this.getValCase(indX,indY)==0) {
								this.setEtatCase(indX, indY, false);
							}else {this.setEtatCase(indX, indY, true);}
						}}
					break;
				case 4:
					for (int indX=0; indX<9;indX++) {
						for (int indY=0; indY<9;indY++) {
							this.setValCase(indX,indY,tabfinal4[indX+9*indY]);
							if (this.getValCase(indX,indY)==0) {
								this.setEtatCase(indX, indY, false);
							}else {this.setEtatCase(indX, indY, true);}
						}}
					break; 
				}
				//L'affichage de la grille
				this.Affichage();
				
			}
		
	//Saisir une valeur
	public static int saisirVal() throws IOException {
		int n;
		BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
		do {
			n = Integer.valueOf(flux.readLine()).intValue();
		} while((n<1)||(n>9));
		return n;
	}
	
	//Affichage de la grille
	public void Affichage() {
        StringBuffer sb = new StringBuffer();
		
		for(int indX=0;indX<9;indX++){ 
			for(int indY=0;indY<9;indY++){
				if(indY == 0) {sb.append("| ");}
				
				sb.append("["+this.getValCase(indX,indY)+"]"+" ");
				
				if( (indY == 2) || (indY == 5) || (indY == 8) ) {sb.append("| ");}
				
	}
			if( (indX == 2) || (indX == 5) ) {sb.append("\n|-----------------------------------------|");}
			if(indX == 8) {sb.append("\n-------------------------------------------");}
			sb.append("\n");}
		System.out.println( sb.toString());
	}
	
	//Remplir une case au clavier
	public void remplirClav() throws IOException {
		int i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer la ligne de la case choisie: ");
		i = sc.nextInt();
		System.out.println("Entrer la colonne de la case choisie: ");
		j = sc.nextInt();
		
		if (!this.getEtatCase(i,j)) {
			System.out.println("Entrer une valeur: ");
			int n = saisirVal();
			
			this.setValCase(i,j,n);
			
		}
		else {System.out.println("Veuillez choisir une case non fixe.");}
		this.Affichage();
		
	}
	
	
	//Verifier si toutes les cases sont remplies
	public boolean verifRempli() {
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (this.getValCase(i, j)==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	//Enregistrer une partie dans un fichier nommé "enregistrement"
	public void enregistrer() throws IOException {
		 File file = new File("enregistrement.txt");
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for (int j=0 ; j<9 ; j++) {
	      		 for (int i=0 ; i<9 ; i++) {
	      			writer.println(this.getValCase(i, j));
	      		 }
	           }
			writer.close();
	}

	//Générer une grille à partir d'une partie enregistrée
	public void anciennePartie() throws NumberFormatException, IOException {
		int table[] = new int[81];
		BufferedReader Lecteur = null;
		try {
			
			Lecteur = new BufferedReader(new FileReader("C:/Users/asus/Desktop/ENSI/2ème Semestre/POO/Java/SUDOKU/enregistrement.txt"));
 
           String ligne; 
	       int index = 0; 
	       while ((ligne = Lecteur.readLine()) != null) {
	    	   table[index]=Integer.parseInt(ligne);
	    	   index++;
		       }                 
		}
		catch(FileNotFoundException exc) {
			System.out.println("erreur");
			 exc.printStackTrace(); 
		}
		finally {
            if ( Lecteur!=null ) {
         try {
                 Lecteur.close();
                 } catch( IOException exc) {
	           System.out.println("Fichier mal fermé");
                         exc.printStackTrace(); 
                 }
            }
      }
		for (int indX=0; indX<9;indX++) {
			for (int indY=0; indY<9;indY++) {
				this.setValCase(indX,indY,table[indX+9*indY]);
				if (this.getValCase(indX,indY)==0) {
					this.setEtatCase(indX, indY, false);
				}else {this.setEtatCase(indX, indY, true);}
			}}
		this.Affichage();
	}

	//Résoudre le jeu
	public void solution() throws NumberFormatException, IOException {
		int table[] = new int[81];
		BufferedReader Lecteur = null;
		try {
			
			Lecteur = new BufferedReader(new FileReader(tableauFich[r]));
 
           String ligne; 
	       int index = 0; 
	       while ((ligne = Lecteur.readLine()) != null) {
	    	   table[index]=Integer.parseInt(ligne);
	    	   index++;
		       }             
		}
		catch(FileNotFoundException exc) {
			System.out.println("erreur");
			 exc.printStackTrace(); 
		}
		finally {
            if ( Lecteur!=null ) {
         try {
                 Lecteur.close();
                 } catch( IOException exc) {
	           System.out.println("Fichier mal fermé");
                         exc.printStackTrace(); 
                 }
            }
      }
		for (int indX=0; indX<9;indX++) {
			for (int indY=0; indY<9;indY++) {
				this.setValCase(indX,indY,table[indX+9*indY]);
			}
		}
		this.Affichage();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

