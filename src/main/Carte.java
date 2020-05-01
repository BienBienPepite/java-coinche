package main;
import java.util.Vector;


public class Carte {
	
	protected Valeur valeur;
	protected Couleur couleur;
	protected boolean isAtout;
	
	public Carte(){
		valeur = Valeur.AUCUNE;
		couleur= Couleur.AUCUNE;
		isAtout = false;
	}
	
	public Carte(Valeur nvaleur, Couleur ncouleur) {
		valeur=nvaleur;
		couleur=ncouleur;
		isAtout=false;
	}
	
	
	
	public Valeur getValeur(){
		return this.valeur;
	}
	
	public Couleur getCouleur(){
		return this.couleur;
	}
	
	public boolean getIsAtout(){
		return this.isAtout;
	}
	
	public void setValeur(Valeur nvaleur){
		this.valeur=nvaleur;
	}
	
	public void setCouleur(Couleur ncouleur){
		this.couleur=ncouleur;
	}
	
	public void setIsAtout(boolean b){
		this.isAtout=b;
	}
	
	public void setIsAtout(CouleurEncheres ce){
		this.isAtout = this.couleur.isAtout(ce);
	}
	
	
	
	public void afficher(){
		System.out.print(this.valeur.getValeur() + this.couleur.getCouleur());
	}
	
	public String affichage(){
		return this.valeur.getValeur() + this.couleur.getCouleur();
	}
	
	
	
	public String affichage(boolean bool){
		int val = (bool) ? 1:0;
		String str = " " + "\u2588" + " ";
		switch(val){
		case 1:
			return this.valeur.getValeur() + this.couleur.getCouleur();
		default : 
			return str;
		}
	}
	
	
	public boolean isCouleur(Couleur cou){
		return this.couleur.equals(cou);
	}
	
	
	
	public boolean isCouleurDemandee(Pli slt){
		
		return (slt.getPoignee().isEmpty() || (this.getCouleur() == slt.getPoignee().elementAt(0).getCouleur()));
	}
	
	
	public boolean aUneValeurSuperieure(Carte car, boolean atout){
		return atout && (this.getValeur().getOrdreAtout() < car.getValeur().getOrdreAtout())
				|| !atout && (this.getValeur().getOrdrePasAtout() < car.getValeur().getOrdrePasAtout());
	}
	
	
	public boolean equals(Carte car){
		return ((this.couleur.equals(Couleur.AUCUNE)|| this.valeur.equals(Valeur.AUCUNE))
				&& (car.valeur.equals(Valeur.AUCUNE) || car.couleur.equals(Couleur.AUCUNE)))
				|| (this.couleur.equals(car.couleur) && this.valeur.equals(car.valeur));
	}
	
	
	public boolean isBelote(Joueur j){
		return (j.getHasBelote() && this.isAtout && (this.valeur.equals(Valeur.ROI) || this.valeur.equals(Valeur.DAME)));
	}
	
	
	

}
