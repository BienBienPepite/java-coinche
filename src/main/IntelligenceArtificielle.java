package main;

import java.util.*;

public class IntelligenceArtificielle extends Joueur {
	
	protected int niveau;
	
	
	public int getNiveau(){
		return this.niveau;
	}
	
	public void setNiveau (int n){
		this.niveau = n;
	}
	
	
	public String[] enchere(int ve, CouleurEncheres ce){
		
		/* Renvoie l'enchere de l'IA*/
		
		String[] str = new String[2];
		int bicolore = 0;
		
		/*Si personne n'a enchéri*/
		
		if (ve == 0){
			
			for (int i =0; i<4; i++){
				if (this.nombreCartesParCouleur()[i] == 0) bicolore++;
			}
			if (bicolore > 1)
			
			
		}
		
		
		return str;
	}
	
	
	
	public int[] nombreCartesParCouleur(){
		
		/*renvoie un tableau de 4 entiers correpondant aux nombres de 
		 * cartes de chaque couleur dans la main de l'IA*/
		
		int trefle=0, carreau=0, coeur=0, pique=0;
		
		for (Carte car : this.poignee){
			if (car.getCouleur().equals(Couleur.TREFLE)) trefle++;
			else if (car.getCouleur().equals(Couleur.CARREAU)) carreau++;
			else if (car.getCouleur().equals(Couleur.COEUR)) coeur++;
			else if (car.getCouleur().equals(Couleur.PIQUE)) pique++;
		}
		
		int[] tab = {trefle,carreau,coeur,pique};
		
		return tab;
	}
	
	
	
	
	public Vector<Integer> isInAtout(){
		Vector<Integer> iia = new Vector<Integer>();
		int i=0;
		
		for (Carte car : this.poignee){
			if (car.getIsAtout()){
				iia.add(i);
			}
			i++;
		}
		
		return iia;
	}
	
	
	public Vector<Integer> isInCouleur(Couleur cou){
		Vector<Integer> iic = new Vector<Integer>();
		int i=0;
		
		for (Carte car : this.poignee){
			if (car.isCouleur(cou)){
				iic.add(i);
			}
			i++;
		}
		
		return iic;
	}

}
