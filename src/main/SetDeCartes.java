package main;
import java.util.Vector;


public abstract class SetDeCartes {
	
	protected Vector<Carte> poignee;
	
	SetDeCartes(){
		poignee = new Vector<Carte>();
	}
	
	public Vector<Carte> getPoignee(){
		return this.poignee;
	}
	
	
	
	
	public void ajouterCarte(Carte carte){
		this.poignee.add(carte);
	}
	
	
	
	public void setAtout(CouleurEncheres ce){
		for (Carte car : this.poignee){
			car.setIsAtout(ce);
		}
	}
	
	
	
	
	public Carte meilleureCarteDuSet(Couleur couleurDemandee, CouleurEncheres ce){
		
		boolean enchereToutAt = ce.equals(CouleurEncheres.TOUTATOUT);
		
		Carte best = new Carte();
		
		for (Carte car : this.poignee)
		{
			best = ((best.getIsAtout() && car.getIsAtout() && !enchereToutAt && car.aUneValeurSuperieure(best, true))
				|| (!best.getIsAtout() && car.getIsAtout() && !enchereToutAt)
				|| (!best.getIsAtout() && car.isCouleur(couleurDemandee) && !enchereToutAt && car.aUneValeurSuperieure(best, false)))
				|| (enchereToutAt && car.isCouleur(couleurDemandee) && car.aUneValeurSuperieure(best, true))
				? car : best;
		}
		return best;
	}
	
	
	
	
	public Carte meilleureCarteAJouer(Couleur couleurDemandee, CouleurEncheres ce){
		
		Carte best = new Carte();
		boolean couleurDemandeeAtout = couleurDemandee.isAtout(ce);
		boolean bestCouleurDemandee;
		boolean carCouleurDemandee;
		
		
		for (Carte car : this.poignee)
		{
			bestCouleurDemandee = best.getCouleur().equals(couleurDemandee);
			carCouleurDemandee = car.getCouleur().equals(couleurDemandee);
						
			best = ((couleurDemandeeAtout && bestCouleurDemandee && carCouleurDemandee  && car.aUneValeurSuperieure(best, true))
			|| (couleurDemandeeAtout && !bestCouleurDemandee && carCouleurDemandee)
			|| (!couleurDemandeeAtout && bestCouleurDemandee && carCouleurDemandee && car.aUneValeurSuperieure(best, false))
			|| (!couleurDemandeeAtout && !bestCouleurDemandee && carCouleurDemandee)
			|| (!couleurDemandeeAtout && !bestCouleurDemandee && !carCouleurDemandee && best.getIsAtout() && car.getIsAtout() && car.aUneValeurSuperieure(best, true))
			|| (!couleurDemandeeAtout && !bestCouleurDemandee && !carCouleurDemandee && !best.getIsAtout() && car.getIsAtout())) 
			? car : best;
		}
		
		return best;
		
	}
	
	
	
	public boolean hasAtout(){
		for (Carte car : this.poignee)
		{
			if (car.getIsAtout())
				return true;
		}
		return false;
	}
	
	
	public boolean hasCouleur(Couleur cou){
		for (Carte car : this.poignee){
			if (car.isCouleur(cou))
				return true;
		}
		return false;
	}
	
	
	
	public void afficher(){
		for (Carte car : this.poignee){
			car.afficher();
		}
	}
	
			

}
