package main;
import java.util.Vector;


public class Pli extends SetDeCartes {

	protected Couleur couleurDemandee;
	
	public Pli(){
		super();
		couleurDemandee = Couleur.AUCUNE;
	}
	
	
	public Couleur getCouleurDemandee(){
		return this.couleurDemandee;
	}
	
	
	public void ajouterCarte(Carte car){
		super.ajouterCarte(car);
		this.couleurDemandee = this.poignee.elementAt(0).getCouleur();
		
	}
	
	
	public int compterLesPoints(CouleurEncheres ce){
		int points = 0;
		for (Carte car : this.getPoignee()){
			if (ce.equals(CouleurEncheres.SANSATOUT)){
				points += car.getValeur().getPointsSansAtout();
			}
			else if (car.getIsAtout()){
				points += car.getValeur().getPointsAtout();
			}
			else{
				points += car.getValeur().getPointsPasAtout();
			}
		}
		return points;
	}
	
	
	

}
