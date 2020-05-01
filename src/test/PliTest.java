package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.*;

public class PliTest {

	@Test
	public final void testCompterLesPoints() {
		
		Pli p = new Pli();
		Carte car1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte car2 = new Carte(Valeur.AS, Couleur.TREFLE);
		
		p.ajouterCarte(car1);
		p.ajouterCarte(car2);
		
		CouleurEncheres ce = CouleurEncheres.TREFLE;
		p.setAtout(CouleurEncheres.TREFLE);

		
		if (p.compterLesPoints(ce) != 31){
			fail("Nombre point atout");
		}
		
		
		ce = CouleurEncheres.PIQUE;
		p.setAtout(ce);
		
		if (p.compterLesPoints(ce) != 13){
			fail("Nombre point pas atout");
		}
		
		
		ce = CouleurEncheres.SANSATOUT;
		p.setAtout(ce);
		
		if (p.compterLesPoints(ce) != 21){
			fail("Nombre point pas atout");
		}
		
		
		ce = CouleurEncheres.PIQUE;
		p.getPoignee().clear();
		p.ajouterCarte(new Carte(Valeur.ROI, Couleur.PIQUE));
		p.ajouterCarte(new Carte(Valeur.DAME, Couleur.COEUR));
		p.ajouterCarte(new Carte(Valeur.NEUF, Couleur.PIQUE));
		p.setAtout(ce);
		
		if (p.compterLesPoints(ce) != 21){
			fail("Somme des valeurs");
		}
	}

}
