package main;

public enum PointsEncheres {
	QUATREVINGT("80"),
	QUATREVINGTDIX("90"),
	CENT("100"),
	CENTDIX("110"),
	CENTVINGT("120"),
	CENTTRENTE("130"),
	CENTQUARANTE("140"),
	CENTCINQUANTE("150"),
	CENTSOIXANTE("160"),
	CENTSOIXANTEDIX("170"),
	CENTQUATREVINGT("180"),
	CAPOT("250");
	
	
	private String pointsEncheres;
	
	
	PointsEncheres (String pointsEncheres){
		this.pointsEncheres = pointsEncheres;
	}
	
	
	public String getPointsEncheres(){
		return this.pointsEncheres;
	}
	
	
	public static boolean isPointsEncheres(String pointsEncheres){
		for (PointsEncheres pe : PointsEncheres.values())
		{
			if (pointsEncheres.equals(pe.getPointsEncheres())){
				return true;
			}			
		}
		return false;
	}
	
	
	

}

