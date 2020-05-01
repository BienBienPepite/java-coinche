package main;
import java.util.*;


public class Jeu {
	
	private static int valeurEnchere = 0;
	private static CouleurEncheres couleurEnchere = CouleurEncheres.AUCUNE;
	private static int indiceMeneur = 0; //quel joueur commence à jouer un tour
	private static int indicePremierJoueurEnchere = 0; //quel est le premier joueur à enchérir
	private static int indiceJoueurEnchereMax = 0; // quel est le joueur qui a fait l'enchère maximale
	
	private static boolean isCoinche = false;
	private static boolean isSurCoinche = false;
	
	private static int passe = 0; // s'itère chaque fois qu'un joueur passe, tombe à zéro quand un joueur enchérit
	
	private static int nombrePointsObjectif = 0;
	
	
	public static int getValeurEnchere(){
		return valeurEnchere;
	}
	
	
	
	public static CouleurEncheres getCouleurEnchere(){
		return couleurEnchere;
	}
	
	
	
	public static int getIndiceMeneur(){
		return indiceMeneur;
	}
	
	
	
	public static int getIndicePremierJoueurEnchere(){
		return indicePremierJoueurEnchere;
	}
	
	
	public static int getIndiceJoueurEnchereMax(){
		return indiceJoueurEnchereMax;
	}
	
	
	
	public static boolean getIsCoinche(){
		return isCoinche;
	}
	
	
	public static boolean getIsSurCoinche(){
		return isSurCoinche;
	}
	
	
	public static int getPasse(){
		return passe;
	}
	
	
	public static int getNombrePointsObjectif(){
		return nombrePointsObjectif;
	}
	

	
	public static void initialisationPartie(boolean hasard){
		String rep = new String();
		System.out.println("En combien de points ?");
		Scanner sc = new Scanner(System.in);
		if (hasard){
			rep = "3000";
			System.out.println("3000");
		}
		else{
			rep = sc.nextLine();
		}
		nombrePointsObjectif = Integer.parseInt(rep);
	}
	
	
	
	public static void distribution(Joueur[] joueur){
		Paquet paquet = new Paquet();
		paquet.melanger();
		paquet.distribuer(joueur);
	}
	
	
	
	public static void initialisationDonne(Joueur[] j){
		
		indicePremierJoueurEnchere = (indicePremierJoueurEnchere+1)%4;
		
		passe = 0;
		
		valeurEnchere=0;
		couleurEnchere=CouleurEncheres.AUCUNE;
		isCoinche=false;
		isSurCoinche = false;
		
		for (int i=0; i<4; i++){
			j[i].getPoignee().clear();
			j[i].setValeurEnchereJoueur("");
			j[i].setCouleurEnchereJoueur(CouleurEncheres.AUCUNE);
			j[i].setOrdreJoueur((i-indicePremierJoueurEnchere+4)%4); 
			j[i].setNombrePointsUneDonne(0);
		}
	}
	
	
	
	public static void encheres(Joueur[] joueur, boolean hasard){
		
		int indiceJoueurCourant = indicePremierJoueurEnchere; // joueur à qui c'est le tour
		Joueur joueurCourant = joueur[indiceJoueurCourant];
		
		double aleatoire = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
	
		while (passe!=4 && valeurEnchere != 250 && isCoinche == false){
						
			String rep = "";
			
			while (!rep.equals("O") && !rep.equals("n")){
				
				System.out.print(AffichageJeu.affichagePlateau(joueur, indiceMeneur, new Pli(), indiceJoueurCourant, false));
				
				System.out.println("Joueur " + (indiceJoueurCourant+1) + ", voulez-vous enchérir ? (O/n)");
				if (hasard){
					aleatoire = (Math.random()*4);
					if (aleatoire >= 3){
						rep = "O";
					}
					else rep = "n";
					System.out.println(rep);
					//sc.nextLine();
					/*try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
				else{
					rep = sc.nextLine();
				}
				
			}
			
			if (rep.equals("n")){
				passe++;
				joueurCourant.setCouleurEnchereJoueur(CouleurEncheres.AUCUNE);
				joueurCourant.setValeurEnchereJoueur("PASSE");
			}
			
			else{
				passe=0;
				
				/* dans ce qui suit on fait rentrer au joueur une valeur d'enchère
				au joueur et on teste la validité de cette valeur : valide du point
				de vue des règles ? supérieure stricte à l'enchère précédentes ?*/
				
				do{
					System.out.println("Combien ? (" + (Math.max(80,valeurEnchere+10)) + "-180, 250)");
					
					if (hasard){
						Vector<Integer> v = new Vector<Integer>();
						for (int k=Math.max(80, valeurEnchere+10) ; k<=180; k += 10){
							v.add(k);
						}
						v.add(250);
						
						aleatoire = Math.random()*v.size();
						rep = Integer.toString(v.elementAt((int) aleatoire));
						System.out.println(rep);
						//sc.nextLine();
						/*try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					}
					else rep = sc.nextLine();
										
				}while(!PointsEncheres.isPointsEncheres(rep) || (Integer.parseInt(rep) <= valeurEnchere));
					
				
				joueurCourant.setValeurEnchereJoueur(rep); 
				valeurEnchere = Integer.parseInt(rep);
				
				
				/* dans ce qui suit on fait rentrer au joueur une couleur d'enchère
				et on teste la validité de cette couleur : est-ce une couleur qui 
				existe ?*/
				
				do{
					System.out.println("Couleur ? (Tr, Ca, Co, Pi, TA, SA)");
					
					if (hasard){
						String[] c = {"Tr", "Ca", "Co", "Pi", "TA", "SA"};
						aleatoire = Math.random()*6;
						rep = c[(int) aleatoire];
						System.out.println(rep);
						//sc.nextLine();
						/*try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					}
					else rep = sc.nextLine();
					
				}while (!CouleurEncheres.isCouleurEncheres(rep) || (passe==3 && rep.equals(couleurEnchere.getCouleurEncheres())));
				
				joueurCourant.setCouleurEnchereJoueur(CouleurEncheres.couleurEncheresCorrespondante(rep));
				couleurEnchere = CouleurEncheres.couleurEncheresCorrespondante(rep);
				
				indiceJoueurEnchereMax = indiceJoueurCourant;
				
				coincheSurCoinche(indiceJoueurCourant, hasard);
				
				
			}
			
			
			indiceJoueurCourant = (indiceJoueurCourant+1)%4;
			joueurCourant = joueur[indiceJoueurCourant];
			
		}
		
		for (Joueur j : joueur){
			j.setAtout(couleurEnchere);
			j.setHasBelote(couleurEnchere);
		}
		

	}
	
	
	
	private static void coincheSurCoinche(int indiceJoueurCourant, boolean hasard){
		
		Scanner sc = new Scanner(System.in);
		
		int indiceJoueurDroite = (indiceJoueurCourant + 1)%4;
		int indiceJoueurGauche = (indiceJoueurCourant + 3)%4;
		int indicePartenaire = (indiceJoueurCourant + 2)%4;
		int[] tab = {indiceJoueurDroite, indiceJoueurGauche};
		int[] tab2 = {indiceJoueurCourant, indicePartenaire};
		double aleatoire = 0;
		
		
		for (int k : tab){
			String rep ="";
			while (!rep.equals("O") && !rep.equals("n")){
				System.out.print("Joueur " + (k+1) + ", voulez-vous coincher ? (O/n)\n");
				
				if (hasard){
					aleatoire = Math.random()*5;
					rep = (aleatoire < 1) ? "O" : "n";
					System.out.println(rep);
					//sc.nextLine();
					/*try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
				else rep = sc.nextLine();
				
				if (rep.equals("O")){
					isCoinche = true;
				}
			}
			if (isCoinche) break;
		}
		
		if (isCoinche){
			for (int k : tab2){
				String rep2 = "";
				while (!rep2.equals("O") && !rep2.equals("n")){
					System.out.print("Joueur " + (k + 1) + ", voulez-vous surcoincher ? (O/n)\n");
					
					if (hasard){
						aleatoire = Math.random()*3;
						rep2 = (aleatoire < 1) ? "O" : "n";
						System.out.println(rep2);
						//sc.nextLine();
						/*try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					}
					else rep2 = sc.nextLine();
					
					if (rep2.equals("O")){
						isSurCoinche = true;
					}
				}
				if (isSurCoinche) break;
			}
		}
		
		
	}
	
	
	
	public static void uneDonne(Joueur[] joueur, boolean hasard){
		
		indiceMeneur = indicePremierJoueurEnchere;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0;  i<8; i++){
			
			String rep = "";
			Pli cartesTable = new Pli();
			
			for (int j=0; j<4; j++){
				
				int numeroCarte = 0;
				int indiceJoueurCourant = (indiceMeneur+j)%4;
				Joueur joueurCourant = joueur[indiceJoueurCourant];
				Vector<Carte> mainCourante = joueurCourant.getPoignee();
				
				System.out.print(AffichageJeu.affichagePlateau(joueur, indiceMeneur, cartesTable, indiceJoueurCourant, false));

				
				do{
					System.out.print("Joueur " + (indiceJoueurCourant+1) + ", quelle carte voulez-vous jouer ? (1 - " + (mainCourante.size()) + ")\n");
					
					if (hasard){
						
						Vector<Integer> iir = joueurCourant.isInRegle(cartesTable, couleurEnchere);
						double aleatoire = Math.random() * iir.size();
						rep = Integer.toString(iir.elementAt((int) aleatoire)+1);
						
						
						System.out.println(rep);
						
						/*try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						//sc.nextLine();
						
					}
					else rep = sc.nextLine();
					
					numeroCarte = Integer.parseInt(rep);
				
				}while (numeroCarte < 1 || numeroCarte > mainCourante.size() || !reglePourPoserUneCarte(cartesTable, mainCourante.elementAt(numeroCarte - 1), joueurCourant, couleurEnchere));
				
				
				cartesTable.ajouterCarte(mainCourante.get(numeroCarte-1));
				mainCourante.remove(numeroCarte-1);
				
			}
			
			System.out.print(AffichageJeu.affichagePlateau(joueur, indiceMeneur, cartesTable, indiceMeneur, false));
						
			indiceMeneur = (indiceMeneur + cartesTable.getPoignee().indexOf(cartesTable.meilleureCarteDuSet(cartesTable.getCouleurDemandee(), couleurEnchere)))%4;
			
			//sc.nextLine();
						
			joueur[indiceMeneur].addNombrePointsUneDonne(cartesTable, couleurEnchere); 
			
			
			
			
			for (int j = 0; j<4; j++){
				joueur[j].setOrdreJoueur((j-indiceMeneur+4)%4); 
			}
			
		}
		
		if (!couleurEnchere.equals(CouleurEncheres.TOUTATOUT)){
			joueur[indiceMeneur].addNombrePointsUneDonne(10); //dix de der
		}
			
	}
	
	
	public static boolean reglePourPoserUneCarte(Pli table, Carte carteJouee, Joueur joueurCourant, CouleurEncheres ce){
		
		boolean couleurDemandeeAtout = table.getCouleurDemandee().isAtout(ce);
		
		boolean carteJoueeCouleurDemandee = carteJouee.getCouleur().equals(table.getCouleurDemandee());
		
		boolean carteJoueeAtoutMaitre = carteJouee.getIsAtout() 
				&& (!table.meilleureCarteDuSet(table.getCouleurDemandee(), ce).getIsAtout()
						|| carteJouee.aUneValeurSuperieure(table.meilleureCarteDuSet(table.getCouleurDemandee(), ce), true));
		
		boolean joueurAPlusAtout = joueurCourant.meilleureCarteDuSet(table.getCouleurDemandee(), ce).getIsAtout() 
				&& (!table.meilleureCarteDuSet(table.getCouleurDemandee(), ce).getIsAtout() 
						|| joueurCourant.meilleureCarteDuSet(table.getCouleurDemandee(), ce).aUneValeurSuperieure(table.meilleureCarteDuSet(table.getCouleurDemandee(), ce), true));
		
		boolean joueurACouleurDemandee = joueurCourant.hasCouleur(table.getCouleurDemandee());
		
		boolean partenaireMaitre = joueurCourant.isPartenaireMaitre(table, ce);
		
		
		return table.getPoignee().isEmpty()
				|| (couleurDemandeeAtout && ((carteJoueeCouleurDemandee && (carteJoueeAtoutMaitre || !joueurAPlusAtout)) || !joueurACouleurDemandee))
				|| (!couleurDemandeeAtout && carteJoueeCouleurDemandee)
				|| (!couleurDemandeeAtout && !joueurACouleurDemandee && (partenaireMaitre || carteJoueeAtoutMaitre || !joueurAPlusAtout));
		
	}
	
	
	
	
	public static void finDeDonne(Joueur joueur[], int indJoueurParti, CouleurEncheres ce, int enchere, boolean coinche, boolean surcoinche){
		
		int beloteEquipeEnchereMax = ((joueur[indJoueurParti].getHasBelote() || joueur[(indJoueurParti+2)%4].getHasBelote()) ? 20 : 0);
		int beloteAutreEquipe = ((joueur[(indJoueurParti+1)%4].getHasBelote() || joueur[(indJoueurParti+3)%4].getHasBelote()) ? 20 : 0);
		
		int nombrePointsEquipeEnchereMax = 0;
		int nombrePointsAutreEquipe = 0;
		
		if (ce.equals(CouleurEncheres.TOUTATOUT)){
			for (int k=0; k<4; k++){
				double pt = 0;
				pt = ((double) joueur[k].getNombrePointsUneDonne()) * ((double) 162/248);
				joueur[k].setNombrePointsUneDonne((int) pt);
			}
		}
		
		if (joueur[(indJoueurParti+1)%4].getNombrePointsUneDonne() + joueur[(indJoueurParti+3)%4].getNombrePointsUneDonne() == 0){
			nombrePointsEquipeEnchereMax = 250 + beloteEquipeEnchereMax;
		}
		else{
			nombrePointsEquipeEnchereMax = joueur[indJoueurParti].getNombrePointsUneDonne() + joueur[(indJoueurParti+2)%4].getNombrePointsUneDonne() + beloteEquipeEnchereMax;
			nombrePointsAutreEquipe = joueur[(indJoueurParti+1)%4].getNombrePointsUneDonne() + joueur[(indJoueurParti+3)%4].getNombrePointsUneDonne() + beloteAutreEquipe;
		}
		
		
		
		if (nombrePointsEquipeEnchereMax < enchere){ //si l'équipe partie a perdu;
			if (coinche){
				if (surcoinche)
					joueur[(indJoueurParti+1)%4].addNombrePointsEquipe(enchere*4 + 160);
				else{
					joueur[(indJoueurParti+1)%4].addNombrePointsEquipe(enchere*2 + 160);
				}
			}
			else{
				joueur[(indJoueurParti+1)%4].addNombrePointsEquipe(enchere + 160);			
			}
			joueur[indJoueurParti].addNombrePointsEquipe(beloteEquipeEnchereMax);
		}
		else{
			if (coinche){
				if (surcoinche)
					joueur[indJoueurParti].addNombrePointsEquipe(enchere*4 + 160);
				else{
					joueur[indJoueurParti].addNombrePointsEquipe(enchere*2 + 160);
				}
				joueur[(indJoueurParti+1)%4].addNombrePointsEquipe(beloteAutreEquipe);
			}
			else{
				int arrondiEnchereMax = ((nombrePointsEquipeEnchereMax%10) >= 5) ? 10 : 0;
				int arrondiAutre = ((nombrePointsAutreEquipe%10) >= 5) ? 10 : 0;
				
				joueur[indJoueurParti].addNombrePointsEquipe(enchere + (nombrePointsEquipeEnchereMax - (nombrePointsEquipeEnchereMax%10) + arrondiEnchereMax));
				joueur[(indJoueurParti+1)%4].addNombrePointsEquipe(nombrePointsAutreEquipe - (nombrePointsAutreEquipe%10) + arrondiAutre);
			}
		}
		
		int totalEquipe1 = joueur[indJoueurParti].getNombrePointsEquipe();
		int totalEquipe2 = joueur[(indJoueurParti+1)%4].getNombrePointsEquipe();
		
		joueur[(indJoueurParti+3)%4].setNombrePointsEquipe(joueur[(indJoueurParti+1)%4].getNombrePointsEquipe());
		joueur[(indJoueurParti+2)%4].setNombrePointsEquipe(joueur[indJoueurParti].getNombrePointsEquipe());


	}
	
	
	

}
