package test;

import static org.junit.Assert.*;

import main.*;

import org.junit.Test;

public class CouleurTest {

	@Test
	public void isAtoutTest() {
		
		CouleurEncheres ce = CouleurEncheres.TREFLE;
		
		if (!Couleur.TREFLE.isAtout(ce)){
			fail("Une couleur d'enchère, Expected <atout>, return <pas atout>");
		}
		
		
		ce = CouleurEncheres.COEUR;
		
		if (Couleur.TREFLE.isAtout(ce)){
			fail("Une couleur d'enchère, Expected <pas atout>, return <atout>");
		}
		
		
		ce = CouleurEncheres.TOUTATOUT;
		
		if (!Couleur.TREFLE.isAtout(ce)){
			fail("Tout atout, Expected <atout>, return <pas atout>");
		}
		
		
		ce = CouleurEncheres.SANSATOUT;
		
		if (Couleur.TREFLE.isAtout(ce)){
			fail("Sans atout, Expected <pas atout>, return <atout>");
		}
		
		
		ce = CouleurEncheres.AUCUNE;
		
		if (Couleur.TREFLE.isAtout(ce)){
			fail("Sans atout, Expected <pas atout>, return <atout>");
		}
		
	}
		

}
