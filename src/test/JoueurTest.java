package test;

import static org.junit.Assert.*;

import main.*;

import org.junit.Test;

public class JoueurTest {
	
	@Test
	public final void testHasBelote(){
		Joueur j = new Joueur();
		
		j.ajouterCarte(new Carte(Valeur.ROI, Couleur.TREFLE));
		j.ajouterCarte(new Carte(Valeur.DAME, Couleur.TREFLE));
		j.ajouterCarte(new Carte(Valeur.DAME, Couleur.CARREAU));
		j.ajouterCarte(new Carte(Valeur.ROI, Couleur.PIQUE));
		
		
		CouleurEncheres ce = CouleurEncheres.TREFLE;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (!j.getHasBelote()){
			fail("expected <true>, return <false>");
		}
		
		
		ce = CouleurEncheres.PIQUE;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (j.getHasBelote()){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.COEUR;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (j.getHasBelote()){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.CARREAU;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (j.getHasBelote()){
			fail("expected <false>, return <true>");
		}
		
		
		ce = CouleurEncheres.TOUTATOUT;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (j.getHasBelote()){
			fail("expected <false>, return <true>");
		}
		
		
		
		ce = CouleurEncheres.SANSATOUT;
		j.setAtout(ce);
		j.setHasBelote(ce);
		
		if (j.getHasBelote()){
			fail("expected <false>, return <true>");
		}
	}
	
	
	

	@Test
	public final void testIsPremierJoueurEquipe(){
		
		Joueur joueur = new Joueur();
	
		if (!joueur.isPremierJoueurEquipe()){
			fail("Premier joueur");
		}
		
		joueur.setOrdreJoueur(2);
		
		if (joueur.isPremierJoueurEquipe()){
			fail("Pas premier joueur");
		}
		
	}
	
	
	@Test
	public final void testIsPartenaireMaitre(){
		
		Pli p = new Pli();
		Joueur joueur = new Joueur();
		
		
		joueur.setOrdreJoueur(0);
		CouleurEncheres ce = CouleurEncheres.COEUR;
		p.setAtout(ce);
		
		if (joueur.isPartenaireMaitre(p,ce))
		{
			fail("Pli vide, expected <partenaire non maitre>, return <partenaire maitre>");
		}
		
		
		p.ajouterCarte(new Carte(Valeur.VALET, Couleur.TREFLE));
		
		joueur.setOrdreJoueur(1);
		ce = CouleurEncheres.COEUR;
		p.setAtout(ce);
		
		if (joueur.isPartenaireMaitre(p,ce))
		{
			fail("Pli 1 carte, expected <partenaire non maitre>, return <partenaire maitre>");
		}
		
		
		
		p.ajouterCarte(new Carte(Valeur.AS, Couleur.TREFLE));
		p.ajouterCarte(new Carte(Valeur.VALET, Couleur.PIQUE));
		
		joueur.setOrdreJoueur(3);
		ce = CouleurEncheres.TREFLE;
		p.setAtout(ce);
		
		if (joueur.isPartenaireMaitre(p,ce))
		{
			fail("Pli 3 cartes, expected <partenaire non maitre>, return <partenaire maitre>");
		}
		
		
		joueur.setOrdreJoueur(3);
		ce = CouleurEncheres.PIQUE;
		p.setAtout(ce);
		
		if (joueur.isPartenaireMaitre(p, ce))
		{
			fail("Pli 3 cartes, expected <partenaire non maitre>, return <partenaire maitre>");
		}
		
		
		joueur.setOrdreJoueur(3);
		ce = CouleurEncheres.COEUR;
		p.setAtout(ce);
		
		if (!joueur.isPartenaireMaitre(p, ce))
		{
			fail("Pli 3 cartes, expected <partenaire maitre>, return <partenaire non maitre>");
		}
		
	}

}
