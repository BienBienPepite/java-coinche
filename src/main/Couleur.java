package main;

public enum Couleur {	
	TREFLE ("\u2663"),
	CARREAU ("\u2666"),
	COEUR ("\u2665"),
	PIQUE ("\u2660"),
	
	AUCUNE ("");
	
	private String couleur;
	
	Couleur(){
		this.couleur = "";
	}
	
	Couleur (String couleur){
		this.couleur = couleur;
	}
	
	public String getCouleur(){
		return this.couleur;
	}
	
	
	public boolean isAtout(CouleurEncheres ce){
		switch (ce){
		case TREFLE: if (this.equals(Couleur.TREFLE)) return true; else return false;
		case CARREAU: if (this.equals(Couleur.CARREAU)) return true; else return false;
		case COEUR: if (this.equals(Couleur.COEUR)) return true; else return false;
		case PIQUE: if (this.equals(Couleur.PIQUE)) return true; else return false;
		case TOUTATOUT : return true;
		case SANSATOUT : return false;
		case AUCUNE : return false;
		default : return false;
		}
	}


}
