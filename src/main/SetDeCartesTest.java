package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetDeCartesTest extends SetDeCartes {
	
	
	@Test
	public void testSetAtout(){
		SetDeCartesTest sdc = new SetDeCartesTest();
		
		sdc.ajouterCarte(new Carte(Valeur.VALET, Couleur.TREFLE));
		
		
		sdc.setAtout(CouleurEncheres.TREFLE);
		
		if (!sdc.getPoignee().elementAt(0).getIsAtout()){
			fail("Enchere une couleur, expected <atout>, return <pas atout>");
		}
		
		
		
		sdc.setAtout(CouleurEncheres.CARREAU);
		
		if (sdc.getPoignee().elementAt(0).getIsAtout()){
			fail("Enchere une couleur, expected <pas atout>, return <atout>");
		}
		
		
		sdc.setAtout(CouleurEncheres.TOUTATOUT);
		
		if (!sdc.getPoignee().elementAt(0).getIsAtout()){
			fail("Enchere tout atout, expected <atout>, return <pas atout>");
		}
		
		
		sdc.setAtout(CouleurEncheres.SANSATOUT);
		
		if (sdc.getPoignee().elementAt(0).getIsAtout()){
			fail("Enchere sans atout, expected <pas atout>, return <atout>");
		}
		
		
		sdc.setAtout(CouleurEncheres.AUCUNE);
		
		if (sdc.getPoignee().elementAt(0).getIsAtout()){
			fail("Enchere aucune, expected <pas atout>, return <atout>");
		}
			
			
	}
	

	@Test
	public void testMeilleureCarteDuSet() {
		
		SetDeCartesTest sdc = new SetDeCartesTest();
		Carte carteVide = new Carte();
		
		CouleurEncheres ce = CouleurEncheres.TREFLE;
		Couleur couleurDemandee = Couleur.TREFLE;
		/*sdc.setAtout(CouleurEncheres.TREFLE);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee).equals(carteVide)){
			fail("Set de cartes vide");
		}*/
		
		
		Carte car1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte car3 = new Carte(Valeur.AS, Couleur.PIQUE);
		Carte car4 = new Carte(Valeur.VALET, Couleur.CARREAU);
		
		sdc.ajouterCarte(car1);
		sdc.ajouterCarte(car2);
		sdc.ajouterCarte(car3);
		sdc.ajouterCarte(car4);
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.TREFLE;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car1)){
			fail("Couleur demandee = Atout, Valet meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.PIQUE;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car3)){
			fail("Couleur demandee pas Atout, As atout meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.CARREAU;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car4)){
			fail("Couleur demandee pas Atout, Valet atout meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.COEUR;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car2)){
			fail("Couleur demandee pas Atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.COEUR;
		ce = CouleurEncheres.COEUR;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(carteVide)){
			fail("Couleur demandee Atout, pas de meilleure carte");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.TOUTATOUT;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car1)){
			fail("Enchere tout atout, Valet couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		ce = CouleurEncheres.SANSATOUT;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(car2)){
			fail("Enchere sans atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.COEUR;
		ce = CouleurEncheres.SANSATOUT;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(carteVide)){
			fail("Enchere sans atout, Aucune carte couleur demandee");
		}
		
		
		couleurDemandee = Couleur.COEUR;
		ce = CouleurEncheres.TOUTATOUT;
		sdc.setAtout(ce);
		
		if (!sdc.meilleureCarteDuSet(couleurDemandee, ce).equals(carteVide)){
			fail("Enchere tout atout, Aucune carte couleur demandee");
		}
	}
	
	
	@Test
	public void testMeilleureCarteAJouer() {
		
		SetDeCartesTest sdc = new SetDeCartesTest();
		Carte carteVide = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		
		Couleur couleurDemandee = Couleur.TREFLE;
		/*Jeu.setAtout(CouleurEncheres.TREFLE);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.TREFLE).equals(carteVide)){
			fail("Set de cartes vide");
		}*/
		
		
		Carte car1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte car3 = new Carte(Valeur.AS, Couleur.PIQUE);
		Carte car4 = new Carte(Valeur.VALET, Couleur.CARREAU);

		
		sdc.ajouterCarte(car1);
		sdc.ajouterCarte(car2);
		sdc.ajouterCarte(car3);
		sdc.ajouterCarte(car4);
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.TREFLE);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.TREFLE).equals(car1)){
			fail("Couleur demandee = Atout, Valet meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.PIQUE);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.PIQUE).equals(car2)){
			fail("Couleur demandee pas Atout, As demande meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.CARREAU);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.CARREAU).equals(car2)){
			fail("Couleur demandee pas Atout, As demande meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.COEUR);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.COEUR).equals(car2)){
			fail("Couleur demandee pas Atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.TOUTATOUT);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.TOUTATOUT).equals(car1)){
			fail("Enchere tout atout, Valet couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.TREFLE;
		sdc.setAtout(CouleurEncheres.SANSATOUT);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.SANSATOUT).equals(car2)){
			fail("Enchere sans atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.CARREAU;
		sdc.setAtout(CouleurEncheres.TREFLE);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.TREFLE).equals(car4)){
			fail("Enchere sans atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.CARREAU;
		sdc.setAtout(CouleurEncheres.SANSATOUT);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.SANSATOUT).equals(car4)){
			fail("Enchere sans atout, As couleur demandee meilleure");
		}
		
		
		couleurDemandee = Couleur.COEUR;
		sdc.setAtout(CouleurEncheres.SANSATOUT);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.SANSATOUT).equals(carteVide)){
			fail("Enchere sans atout, Aucune carte couleur demandee");
		}
		
		
		couleurDemandee = Couleur.COEUR;
		sdc.setAtout(CouleurEncheres.TOUTATOUT);
		
		if (!sdc.meilleureCarteAJouer(couleurDemandee, CouleurEncheres.TOUTATOUT).equals(carteVide)){
			fail("Enchere tout atout, Aucune carte couleur demandee");
		}
	}
	
	
	
	@Test
	public void testHasAtout(){
		
		SetDeCartesTest sdc = new SetDeCartesTest();
		
		sdc.setAtout(CouleurEncheres.PIQUE);
		
		if (sdc.hasAtout()){
			fail("Ensemble de cartes vide");
		}
		
		
		Carte car1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte car3 = new Carte(Valeur.AS, Couleur.PIQUE);
		Carte car4 = new Carte(Valeur.VALET, Couleur.CARREAU);
		
		sdc.ajouterCarte(car1);
		sdc.ajouterCarte(car2);
		sdc.ajouterCarte(car3);
		sdc.ajouterCarte(car4);
		
		
		sdc.setAtout(CouleurEncheres.PIQUE);
		
		if (!sdc.hasAtout()){
			fail("Enchere couleur, SDC a atout");
		}
		
		
		sdc.setAtout(CouleurEncheres.COEUR);
		
		if (sdc.hasAtout()){
			fail("Enchere couleur, SDC pas atout");
		}
		
		
		sdc.setAtout(CouleurEncheres.TOUTATOUT);
		
		if (!sdc.hasAtout()){
			fail("Enchere tout atout");
		}
		
		
		sdc.setAtout(CouleurEncheres.SANSATOUT);
		
		if (sdc.hasAtout()){
			fail("Enchere sans atout");
		}
		
		
		sdc.setAtout(CouleurEncheres.AUCUNE);
		
		if (sdc.hasAtout()){
			fail("Aucune Enchere");
		}
	}
	
	
	
	
	@Test
	public void testHasCouleur(){
		
		SetDeCartesTest sdc = new SetDeCartesTest();
		
		
		if (sdc.hasCouleur(Couleur.PIQUE)){
			fail("Ensemble de cartes vide");
		}
		
		
		Carte car1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte car3 = new Carte(Valeur.AS, Couleur.PIQUE);
		Carte car4 = new Carte(Valeur.VALET, Couleur.CARREAU);
		
		sdc.ajouterCarte(car1);
		sdc.ajouterCarte(car2);
		sdc.ajouterCarte(car3);
		sdc.ajouterCarte(car4);
		
		
		
		if (!sdc.hasCouleur(Couleur.TREFLE)){
			fail("A couleur");
		}
		
		if (!sdc.hasCouleur(Couleur.PIQUE)){
			fail("A couleur");
		}
		
		if (sdc.hasCouleur(Couleur.COEUR)){
			fail("N'a pas couleur");
		}
		
		if (sdc.hasCouleur(Couleur.AUCUNE)){
			fail("N'a pas aucune couleur");
		}
	}

}
