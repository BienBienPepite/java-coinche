package test;

import static org.junit.Assert.*;

import main.*;

import org.junit.Test;

public class JeuTest {

	@Test
	public final void testReglePourPoserUneCarte(){
		
		Joueur j = new Joueur();
		Pli p = new Pli();
		
		Carte carJoueur1 = new Carte(Valeur.AS, Couleur.TREFLE);
		Carte carJoueur2 = new Carte(Valeur.VALET, Couleur.CARREAU);
		Carte carJoueur3 = new Carte(Valeur.HUIT, Couleur.CARREAU);
		Carte carJoueur4 = new Carte(Valeur.SEPT, Couleur.COEUR);
		
		j.ajouterCarte(carJoueur1);
		j.ajouterCarte(carJoueur2);
		j.ajouterCarte(carJoueur3);
		j.ajouterCarte(carJoueur4);
		
		Carte carPli1 = new Carte(Valeur.VALET, Couleur.TREFLE);
		Carte carPli2 = new Carte(Valeur.AS, Couleur.CARREAU);
		Carte carPli3 = new Carte(Valeur.DAME, Couleur.PIQUE);
		Carte carPli4 = new Carte(Valeur.NEUF, Couleur.CARREAU);
		Carte car1Pli5 = new Carte(Valeur.AS, Couleur.PIQUE);
		Carte car2Pli5 = new Carte(Valeur.VALET, Couleur.PIQUE);
		Carte car3Pli6 = new Carte(Valeur.ROI, Couleur.TREFLE);
		Carte car3Pli7 = new Carte(Valeur.NEUF, Couleur.TREFLE);
		Carte car1Pli8 = new Carte(Valeur.AS, Couleur.CARREAU);
		Carte car2Pli8 = new Carte(Valeur.SEPT, Couleur.PIQUE);
		
		
		CouleurEncheres ce = CouleurEncheres.CARREAU;
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(0);
		
		Carte c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli vide, expected <true>, return <false>");
		}
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(carPli1);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(1);
		
		c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <false>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.CARREAU;
		p.getPoignee().clear();
		p.ajouterCarte(carPli2);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(1);
		
		
		c = j.getPoignee().elementAt(0);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <false>, return <false>");
		}
		
		c = j.getPoignee().elementAt(2);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <false>, return <false>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <true>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.PIQUE;
		p.getPoignee().clear();
		p.ajouterCarte(carPli3);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(1);
		
		c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte atout, expected <true>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(carPli4);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(1);
		
		c = j.getPoignee().elementAt(0);
				
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte pas atout, expected <false>, return <true>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte pas atout, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(2);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte pas atout, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(3);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 1 carte pas atout, expected <false>, return <true>");
		}
		
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(car1Pli5);
		p.ajouterCarte(car2Pli5);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(2);
		
		c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Partenaire maitre, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Partenaire maitre, expected <true>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(car1Pli5);
		p.ajouterCarte(car2Pli5);
		p.ajouterCarte(car3Pli6);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(3);
		
		c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <false>, return <true>");
		}
		
		
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(car1Pli5);
		p.ajouterCarte(car2Pli5);
		p.ajouterCarte(car3Pli7);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(3);
		
		c = j.getPoignee().elementAt(0);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(3);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.TREFLE;
		p.getPoignee().clear();
		p.ajouterCarte(car1Pli8);
		p.ajouterCarte(car2Pli8);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(2);
		
		c = j.getPoignee().elementAt(0);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <false>, return <true>");
		}
		
		c = j.getPoignee().elementAt(1);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
		
		c = j.getPoignee().elementAt(2);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
		
		
		
		ce = CouleurEncheres.COEUR;
		p.getPoignee().clear();
		p.ajouterCarte(car1Pli5);
		p.ajouterCarte(car2Pli5);
		p.ajouterCarte(car3Pli6);
		p.setAtout(ce);
		j.setAtout(ce);
		j.setOrdreJoueur(3);
		
		c=j.getPoignee().elementAt(0);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <false>, return <true>");
		}
		
		c=j.getPoignee().elementAt(1);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <false>, return <true>");
		}
		
		c=j.getPoignee().elementAt(2);
		
		if (Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <false>, return <true>");
		}
		
		c=j.getPoignee().elementAt(3);
		
		if (!Jeu.reglePourPoserUneCarte(p, c, j, ce)){
			fail("Pli 3 cartes, expected <true>, return <false>");
		}
	}

}
