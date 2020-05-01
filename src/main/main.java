package main;

public class main {

	public static void main(String[] args) {
		
		
		//initialisation
		boolean hasard = true;
		
		Joueur joueur[]= new Joueur[4];
		for(int i=0; i<4; i++){
			joueur[i] = new Joueur();
			joueur[i].setOrdreJoueur(i); //le premier joueur de la première manche est le joueur 0
		}
		
		
		/* TODO paramètres à initialiser par le joueur :
		    - manière de compter (seulement contrat, contrat + points ?)
		    - options de règles (jamais obligé de sous-couper ?)*/
		
		Jeu.initialisationPartie(hasard);
		
		
		//déroulement de la partie
		
		while((joueur[0].getNombrePointsEquipe() < Jeu.getNombrePointsObjectif()) && (joueur[1].getNombrePointsEquipe() < Jeu.getNombrePointsObjectif())){
		
			Jeu.distribution(joueur);
			Jeu.encheres(joueur, hasard);
			if (!Jeu.getCouleurEnchere().equals(CouleurEncheres.AUCUNE) || !(Jeu.getValeurEnchere()==0)){
				Jeu.uneDonne(joueur, hasard);
				Jeu.finDeDonne(joueur, Jeu.getIndiceJoueurEnchereMax(), Jeu.getCouleurEnchere(), Jeu.getValeurEnchere(), Jeu.getIsCoinche(), Jeu.getIsSurCoinche());
			}
			Jeu.initialisationDonne(joueur);
			
			System.out.println(joueur[0].getNombrePointsEquipe() + "   " + joueur[1].getNombrePointsEquipe());
		
		}

	}

}
