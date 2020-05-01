package main;

public enum CouleurEncheres {
	AUCUNE (""),
	TREFLE ("Tr"),
	CARREAU ("Ca"),
	COEUR ("Co"),
	PIQUE ("Pi"),
	SANSATOUT ("SA"),
	TOUTATOUT ("TA");
	
	private String couleurEncheres;
	
	
	CouleurEncheres (String couleurEncheres){
		this.couleurEncheres = couleurEncheres;
	}
	
	
	
	public String getCouleurEncheres(){
		return this.couleurEncheres;
	}
	
	
	
	public static boolean isCouleurEncheres(String couleurEncheres){
		for (CouleurEncheres ce : CouleurEncheres.values())
		{
			if (couleurEncheres.equals(ce.getCouleurEncheres())){
				return true;
			}			
		}
		return false;
	}
	
	
	public Couleur couleurCorrespondante(){
		
		switch(this){
		case AUCUNE: 
		case TOUTATOUT:
		case SANSATOUT: return Couleur.AUCUNE;
		case TREFLE: return Couleur.TREFLE;
		case CARREAU: return Couleur.CARREAU;
		case COEUR: return Couleur.COEUR;
		case PIQUE: return Couleur.PIQUE;
		default: return Couleur.AUCUNE;
		}
	}
	
	
	
	public static CouleurEncheres couleurEncheresCorrespondante(String couleurEncheres){
		
		for (CouleurEncheres ce : CouleurEncheres.values())
		{
			if (couleurEncheres.equals(ce.getCouleurEncheres())){
				return ce;
			}			
		}
		return AUCUNE;
	}
	

}
