package sudoku;


import java.io.IOException;
import java.util.Scanner;



public class Sudoku {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Le principe du jeu
		System.out.println("********************** Jeu SUDOKU ********************** \n\n1"+"Les règles du SUDOKU sont très simples. Un SUDOKU classique contient neuf lignes et neuf colonnes, donc 81 cases au total.\r\n" + 
				"Le but du jeu est de remplir ces cases avec des chiffres allant de 1 à 9 en veillant toujours à ce qu'un même chiffre ne figure qu'une seule fois par colonne,\nune seule fois par ligne, et une seule fois par carré de neuf cases.\n\n"
				+"Dans la grille qui va vous apparaître, par la suite, une case contenant la valeur 0 est une case vide que vous devez remplir.\n\n"+"1 est équivalent à Oui \n0 est équivalent à Non.\n\n");
		//Le joueur a le choix d'entamer une nouvelle partie ou de continuer avec une ancienne
				Scanner mode = new Scanner(System.in);
				
				System.out.println("Choisissez un mode : \n"
						+ "                  1-Nouvelle Partie \n"
						+ "                  2-Ancienne Partie");
				int partie = mode.nextInt();
				Jeu jeu = new Jeu();
				Scanner scan = new Scanner(System.in);
				switch(partie) {
				//Dans le cas où le joueur choisit une nouvelle partie
					case 1 :
						
						//Le joueur doit choisir un niveau de difficulté
						
						System.out.println("Choisir une difficulté : \n"
								+ "                  1-Facile \n"
								+ "                  2-Moyen \n"
								+ "                  3-Difficile \n"
								+ "                  4-Très Difficile");
						
						Scanner difficulte = new Scanner(System.in);
						int niveau = difficulte.nextInt();
						
						int reponse;
						//La grille v se remplir selon le niveau choisi
						switch(niveau) {
						case 1:
							jeu.remplirAlea(1);
							
							break;
						case 2:
							jeu.remplirAlea(2);
							
							break;
						case 3:
							jeu.remplirAlea(3);
							
							break;
						case 4:
							jeu.remplirAlea(4);
							
							break;
						}
						//Tant qu'il y a toujours des cases vides et que le joueur veut continuer, il peut entrer une valeur dans une case de son choix
						do {
						jeu.remplirClav();
						System.out.println("Tapez 1 pour continuer.");
						
						reponse=scan.nextInt();
							
						} while(!jeu.verifRempli() && reponse==1 );
						
						//Si le joueur ne veut plus continuer, il pourra quitter ou voir la solution
						//S'il choisit de quitter, il pourra enregistrer sa partie
						if (!jeu.verifRempli()) {
							System.out.println("Tapez 1 si vous voulez quitter. Tapez 2 si vous voulez voir la solution.");
							int rep1=scan.nextInt();
							if(rep1==2) {
								jeu.solution();
							}else if (rep1==1) {
								System.out.println("Tapez 1 si vous voulez enregistrer la partie. Tapez 0 sinon.");
								int rep2=scan.nextInt();
								if (rep2==1) {
									jeu.enregistrer();
									System.out.println("Votre partie est enregistrée. Au revoir!");
									
								}else {System.out.println("Au revoir!");}
							}
							
						}
							
						//S'il n'ya plus de cases vides, on vérifie si le joueur a gagné	
						else {
							if (jeu.gagne()) {
								System.out.println("Félicitations! Vous avez gagné!");
							}else {System.out.println("Désolé! vous avez échoué. Voulez-vous voir la solution? ");
							Scanner sc = new Scanner(System.in);
								   int rep3 = sc.nextInt();
								   if (rep3 == 1) {
									   jeu.solution();
									   }
								   else {System.out.println("Au revoir!");}
							}
						}
						
						break;
					//Dans le cas où le joueur choisit une ancienne partie
					case 2 :
						//La grille de l'ancienne partie est générée
						jeu.anciennePartie();
						Scanner sc1 = new Scanner(System.in);
						//On procède de la même façon que précédemment
						do {
							jeu.remplirClav();
							System.out.println("Voulez-vous continuer ?");
							reponse=sc1.nextInt();
								
							} while(!jeu.verifRempli() && reponse==1 );
							
							if (!jeu.verifRempli()) {
								System.out.println("Tapez 1 si vous voulez quitter. Tapez 2 si vous voulez voir la solution.");
								int rep1=scan.nextInt();
								if(rep1==2) {
									jeu.solution();
								}else if (rep1==1) {
									System.out.println("Tapez 1 si vous voulez enregistrer la partie. Tapez 0 sinon.");
									int rep2=scan.nextInt();
									if (rep2==1) {
										jeu.enregistrer();
										System.out.println("Votre partie est enregistrée. Au revoir!");
										
									}else {System.out.println("Au revoir!");}
								}
								
							}
								
							else {
								if (jeu.gagne()) {
									System.out.println("Félicitations! Vous avez gagné!");
								}else {System.out.println("Désolé! vous avez échoué. Voulez-vous voir la solution? ");
								int rep3 = sc1.nextInt();
								   if (rep3 == 1) {
									   jeu.solution();
								   }else {System.out.println("Au revoir!");
								
								}
							}}
						break;
					default :
						System.out.println("************ Veuillez choisir une option parmi celles citées au dessus !! ************");
				}
				
							

	
				}
}

