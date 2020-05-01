package main;
import java.util.Vector;


public class Joueur extends SetDeCartes{
	
	protected int ordreJoueur;
	protected String valeurEnchereJoueur;
	protected CouleurEncheres couleurEnchereJoueur;
	protected int nombrePointsUneDonne; //nombre de points que le joueur fait en une partie
	protected int nombrePointsEquipe; //nombre de points cumulés de l'équipe du joueur
	protected boolean hasBelote;
	
	
	public Joueur(){
		super();
		ordreJoueur= 0;
		valeurEnchereJoueur = "";
		couleurEnchereJoueur = CouleurEncheres.AUCUNE;
		nombrePointsUneDonne=0;
		nombrePointsEquipe = 0;
		hasBelote = false;
	}
	
	public Joueur(Vector<Carte> poig, int oJoueur){
		poignee=poig;
		ordreJoueur=oJoueur;
	}
	
	
	public int getOrdreJoueur(){
		return this.ordreJoueur;
	}
	
	public String getValeurEnchereJoueur(){
		return this.valeurEnchereJoueur;
	}
	
	public CouleurEncheres getCouleurEnchereJoueur(){
		return this.couleurEnchereJoueur;
	}
	
	public int getNombrePointsUneDonne(){
		return this.nombrePointsUneDonne;
	}
	
	public int getNombrePointsEquipe(){
		return this.nombrePointsEquipe;
	}
	
	public boolean getHasBelote(){
		return this.hasBelote;
	}
	
	
	public void setOrdreJoueur(int oJoueur){
		this.ordreJoueur = oJoueur;
	}
	
	public void setNombrePointsUneDonne(int points){
		this.nombrePointsUneDonne = points;
	}
	
	public void setNombrePointsEquipe(int points){
		this.nombrePointsEquipe = points;
	}
	
	public void setValeurEnchereJoueur(String str){
		this.valeurEnchereJoueur = str;
	}
	
	public void setCouleurEnchereJoueur(CouleurEncheres ce){
		this.couleurEnchereJoueur = ce;
	}
	
	
	public void setHasBelote(CouleurEncheres ce){
		
		int belote = 0;
		
		if (!ce.equals(CouleurEncheres.TOUTATOUT) && !ce.equals(CouleurEncheres.SANSATOUT) && !ce.equals(CouleurEncheres.AUCUNE)){
			for (Carte car : this.poignee){
				if (car.getIsAtout() && (car.getValeur().equals(Valeur.DAME) || car.getValeur().equals(Valeur.ROI))){
					belote++;
				}
			}
		}
		this.hasBelote = (belote == 2);
	}
	
	
	
	public boolean isPremierJoueurEquipe(){
		return (this.ordreJoueur < 2);
	}
	
	public boolean isPartenaireMaitre(Pli p, CouleurEncheres ce){
		if (!this.isPremierJoueurEquipe())
				return (p.meilleureCarteDuSet(p.getCouleurDemandee(), ce).equals(p.getPoignee().elementAt((this.getOrdreJoueur()+2)%4)));
		else return false;
	}
	
	
	
	public Vector<Integer> isInRegle(Pli p, CouleurEncheres ce){ //retourne les indices des cartes peut jouer un joueur
		Vector<Integer> iir = new Vector<Integer>();
		int i=0;
		
		for (Carte car : this.poignee){
			if (Jeu.reglePourPoserUneCarte(p, car, this, ce)){
				iir.add(i);
			}
			i++;
		}
		
		return iir;
	}
	
	
	
	public void addNombrePointsUneDonne(int pt){
		this.nombrePointsUneDonne += pt;
	}

	public void addNombrePointsUneDonne(Pli p, CouleurEncheres ce){
		this.nombrePointsUneDonne += p.compterLesPoints(ce);
	}
	
	
	public void addNombrePointsEquipe(int points){
		this.nombrePointsEquipe += points;
	}
	
	
	
	
	public void afficherPoignee(){
		for (int i=0; i<this.poignee.size(); i++){
			System.out.print(this.getPoignee().get(i).affichage() + " ");
		}
	}
	

}
