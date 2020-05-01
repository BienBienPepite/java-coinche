package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import main.*;

public class CarteTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	
	
	@Test
	public final void testIsCouleur() {
		Carte car = new Carte(Valeur.AS, Couleur.CARREAU);
		Couleur cou = Couleur.CARREAU;
		
		if (!car.isCouleur(cou)){
			fail("Carte Carreau different Carreau");
		}
		
		
		car = new Carte(Valeur.AS, Couleur.CARREAU);
		cou = Couleur.PIQUE;
		
		if (car.isCouleur(cou)){
			fail("Carte Carreau est Pique");
		}
		
		
		car = new Carte(Valeur.AS, Couleur.AUCUNE);
		cou = Couleur.CARREAU;
		
		if (car.isCouleur(cou)){
			fail("Carte Aucune est Carreau");
		}
		
		
		car = new Carte(Valeur.AS, Couleur.CARREAU);
		cou = Couleur.AUCUNE;
		
		if (car.isCouleur(cou)){
			fail("Carte Carreau est Aucune");
		}
		
		
		car = new Carte(Valeur.AS, Couleur.AUCUNE);
		cou = Couleur.AUCUNE;
		
		if (!car.isCouleur(cou)){
			fail("Carte Aucune different Aucune");
		}
	}
	
	
	
	@Test
	public final void testSetIsAtout(){
		
		Carte car = new Carte(Valeur.AS, Couleur.CARREAU);
		

		car.setIsAtout(CouleurEncheres.CARREAU);
		
		if (!car.getIsAtout()){
			fail("Une couleur enchere, expected <atout>, return <pas atout>");
		}
		
		
		car.setIsAtout(CouleurEncheres.COEUR);
		
		if (car.getIsAtout()){
			fail("Une couleur enchere, expected <pas atout>, return <atout>");
		}
		
		
		car.setIsAtout(CouleurEncheres.TOUTATOUT);
		
		if (!car.getIsAtout()){
			fail("Tout atout, expected <atout>, return <pas atout>");
		}
		
		
		car.setIsAtout(CouleurEncheres.SANSATOUT);
		
		if (car.getIsAtout()){
			fail("Sans atout, expected <atout>, return <pas atout>");
		}
		
		
		car.setIsAtout(CouleurEncheres.AUCUNE);
		
		if (car.getIsAtout()){
			fail("Aucune enchere, expected <pas atout>, return <atout>");
		}
	}
	
	
	
	@Test
	public final void testIsCouleurDemandee(){
		Pli poignee = new Pli();
		
		Carte car = new Carte(Valeur.AS, Couleur.TREFLE);
		
		if (!car.isCouleurDemandee(poignee)){
			fail("Pli vide");
		}
		
		
		poignee = new Pli();
		
		Carte car1 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.ROI, Couleur.TREFLE);
		poignee.ajouterCarte(car1);
		
		if (!car2.isCouleurDemandee(poignee)){
			fail("2 cartes meme couleur");
		}
		
		
		poignee = new Pli();
		
		car1 = new Carte(Valeur.AS, Couleur.TREFLE);
		car2 = new Carte(Valeur.ROI, Couleur.CARREAU);
		poignee.ajouterCarte(car1);
		
		if (car2.isCouleurDemandee(poignee)){
			fail("2 cartes couleurs differentes");
		}
		
	}
	
	
	

	@Test
	public final void testAUneValeurSuperieure() {
		
		Carte car1 = new Carte(Valeur.ROI, Couleur.CARREAU);
		Carte car2 = new Carte(Valeur.DAME, Couleur.CARREAU);
		boolean atout = true;
		
		if (!car1.aUneValeurSuperieure(car2, atout)){
			fail("Roi inferieur Dame, atout");
		}
		
		
		car1 = new Carte(Valeur.ROI, Couleur.CARREAU);
		car2 = new Carte(Valeur.DAME, Couleur.CARREAU);
		atout = false;
		
		if (!car1.aUneValeurSuperieure(car2, atout)){
			fail("Roi inferieur Dame, pas atout");
		}
		
		
		car1 = new Carte(Valeur.VALET, Couleur.CARREAU);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = true;
		
		if (!car1.aUneValeurSuperieure(car2, atout)){
			fail("Valet inferieur As, atout");
		}
		
		
		car1 = new Carte(Valeur.VALET, Couleur.CARREAU);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = false;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Valet superieur As, pas atout");
		}
		
		
		car1 = new Carte(Valeur.NEUF, Couleur.CARREAU);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = true;
		
		if (!car1.aUneValeurSuperieure(car2, atout)){
			fail("Neuf inferieur As, atout");
		}
		
		
		car1 = new Carte(Valeur.NEUF, Couleur.CARREAU);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = false;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Neuf superieur As, pas atout");
		}
		
		
		car1 = new Carte(Valeur.NEUF, Couleur.COEUR);
		car2 = new Carte(Valeur.NEUF, Couleur.CARREAU);
		atout = true;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Neuf superieur Neuf, atout");
		}
		
		
		car1 = new Carte(Valeur.NEUF, Couleur.COEUR);
		car2 = new Carte(Valeur.NEUF, Couleur.CARREAU);
		atout = false;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Neuf superieur Neuf, pas atout");
		}
		
		
		car1 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = true;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Aucune superieur As, atout");
		}
		
		
		car1 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		car2 = new Carte(Valeur.AS, Couleur.CARREAU);
		atout = false;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Aucune superieur As, pas atout");
		}
		
		
		car1 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		car2 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		atout = true;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Aucune superieur Aucune, atout");
		}
		
		
		car1 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		car2 = new Carte(Valeur.AUCUNE, Couleur.AUCUNE);
		atout = false;
		
		if (car1.aUneValeurSuperieure(car2, atout)){
			fail("Aucune superieur Aucune, pas atout");
		}
	}
	
	
	
	public final void testIsBelote(){
		
		Joueur j = new Joueur();
		
		Carte car1 = new Carte(Valeur.ROI, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.DAME, Couleur.TREFLE);
		Carte car3 = new Carte(Valeur.DAME, Couleur.CARREAU);
		Carte car4 = new Carte(Valeur.ROI, Couleur.PIQUE);
		
		j.ajouterCarte(car1);
		j.ajouterCarte(car2);
		j.ajouterCarte(car3);
		j.ajouterCarte(car4);
		
		
		CouleurEncheres ce = CouleurEncheres.TREFLE;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (!car1.isBelote(j)){
			fail("expected <true>, return <false>");
		}
		
		if (!car2.isBelote(j)){
			fail("expected <true>, return <false>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.PIQUE;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (car1.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car2.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.COEUR;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (car1.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car2.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.CARREAU;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (car1.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car2.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.TOUTATOUT;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (car1.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car2.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
		
		ce = CouleurEncheres.SANSATOUT;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (car1.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car2.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car3.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		if (car4.isBelote(j)){
			fail("expected <false>, return <true>");
		}
		
		
	}

}
