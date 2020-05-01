package main;

public enum Valeur {
	SEPT (" 7", 8, 8, 0, 0, 0),
	HUIT (" 8", 7, 7, 0, 0, 0),
	NEUF (" 9", 6, 2, 14, 0, 0),
	DIX ("10", 2, 4, 10, 10, 10),
	VALET (" V", 5, 1, 20, 2, 2),
	DAME (" D", 4, 6, 3, 3, 3),
	ROI (" R", 3, 5, 4, 4, 4),
	AS (" A", 1, 3, 11, 11, 19),
	
	AUCUNE ("",10,10,0,0,0);
	
	private String valeur;
	private int ordrePasAtout;
	private int ordreAtout;
	private int pointsAtout;
	private int pointsPasAtout;
	private int pointsSansAtout;
	
	Valeur (String valeur, int ordrePasAtout, int ordreAtout, int pointsAtout, int pointsPasAtout, int pointsSansAtout){
		this.valeur = valeur;
		this.ordrePasAtout = ordrePasAtout;
		this.ordreAtout = ordreAtout;
		this.pointsAtout = pointsAtout;
		this.pointsPasAtout = pointsPasAtout;
		this.pointsSansAtout = pointsSansAtout;
	}
	
	public String getValeur(){
		return this.valeur;
	}
	
	public int getOrdrePasAtout() {
		return ordrePasAtout;
	}
	
	public int getOrdreAtout() {
		return ordreAtout;
	}

	public int getPointsAtout(){
		return this.pointsAtout;
	}
	
	public int getPointsPasAtout(){
		return this.pointsPasAtout;
	}
	
	public int getPointsSansAtout(){
		return this.pointsSansAtout;
	}


}
