package main;
import java.util.Vector;


public class AffichageJeu {
	
	public static String affichagePlateau(Joueur[] joueur, int meneur, Pli cartesTable, int indiceJoueurCourant, boolean cache){
		
		/*for (int i=0; i<40; i++){
			System.out.println();
		}*/
		
		
		String[] string = new String[14];
		
		String belote = "";
		
		String retour = "";
		
		
		string[0] = "                   JOUEUR 3                        DERNIER TOUR D'ENCHERE :                        POINTS :\n";
		
		
		string[1]="\n";
		
		
		string[2] = "      ";
		if (cache==true){
			for (int i=0; i<8; i++)
			{
				if (joueur[2].getPoignee().size() > i)
					string[2] += " \u2588  ";
				else
					string[2] += "   ";
			}
		}
		else{
		for (int i=0; i<8; i++)
			{
				if (joueur[2].getPoignee().size() > i){
					//string[2] += joueur[2].getPoignee().elementAt(i).affichage(indiceJoueurCourant==2) + " ";
					string[2] += joueur[2].getPoignee().elementAt(i).affichage() + " ";
				}
				else
					string[2] += "   ";
			}
		}
		string[2] += "                                                  EQUIPE JOUEURS 1-3   ||   EQUIPE JOUEURS 2-4\n";
		
		
		string[3] = "J ";
		string[4] = "O ";
		string[5] = "U ";
		string[6] = "E ";
		string[7] = "U ";
		string[8] = "R ";
		string[9] = "  ";
		string[10] = "4 ";
		
		
		
		for (int i=0; i<8; i++)
		{
			if (cache==true){
				if (joueur[3].getPoignee().size() > i)
					string[i+3] += " \u2588 ";
				else
					string[i+3] += "    ";
			}
			else{
				if (joueur[3].getPoignee().size() > i){
					//string[i+3] += joueur[3].getPoignee().elementAt(i).affichage(indiceJoueurCourant==3);
					string[i+3] += joueur[3].getPoignee().elementAt(i).affichage();
				}
				else
					string[i+3] += "   ";
			}
			
			
			
			for (int k = 0; k<32; k++){
				if (k== 15 && i==2 && (2-meneur+4)%4 < cartesTable.getPoignee().size()){
					string[i+3] += cartesTable.getPoignee().elementAt((2-meneur+4)%4).affichage();
					belote = (cartesTable.getPoignee().elementAt((2-meneur+4)%4).isBelote(joueur[(2-meneur+4)%4])) ? "BELOTE" : "";
					k+=2;
				}
				else if (k== 6 && i==4 && (3-meneur+4)%4 < cartesTable.getPoignee().size()){
					string[i+3] += cartesTable.getPoignee().elementAt((3-meneur+4)%4).affichage();
					belote = (cartesTable.getPoignee().elementAt((3-meneur+4)%4).isBelote(joueur[(3-meneur+4)%4])) ? "BELOTE" : "";
					k+=2;
				}
				else if (k== 23 && i==4 && (1-meneur+4)%4 < cartesTable.getPoignee().size()){
					string[i+3] += cartesTable.getPoignee().elementAt((1-meneur+4)%4).affichage();
					belote = (cartesTable.getPoignee().elementAt((1-meneur+4)%4).isBelote(joueur[(1-meneur+4)%4])) ? "BELOTE" : "";
					k+=2;
				}
				else if (k== 15 && i==6 && (0-meneur+4)%4 < cartesTable.getPoignee().size()){
					string[i+3] += cartesTable.getPoignee().elementAt((0-meneur+4)%4).affichage();
					belote = (cartesTable.getPoignee().elementAt((0-meneur+4)%4).isBelote(joueur[(0-meneur+4)%4])) ? "BELOTE" : "";
					k+=2;
				}
				else
					string[i+3] += " ";
			}
				
				
			
			
			
			if (cache==true){
				if (joueur[1].getPoignee().size() > i)
					string[i+3] += " \u2588 ";
				else
					string[i+3] += "   ";
			}
			else{
				if (joueur[1].getPoignee().size() > i){
					//string[i+3] += joueur[1].getPoignee().elementAt(i).affichage(indiceJoueurCourant==1);
					string[i+3] += joueur[1].getPoignee().elementAt(i).affichage();
				}
				else
					string[i+3] += "   ";
			}
				
			if (i<7){
				string[i+3] += "  " + string[i+3].charAt(0);
			}
			if (i==7)
				string[i+3] += "  2";
				
			
			string[i+3] += "     ";
			
				
			if (i==1 || i==3 || i==5 || i==7){
				string[i+3] += "JOUEUR " + ((Jeu.getIndicePremierJoueurEnchere()+(i-1)/2)%4+1) + " : ";
				
				String str = new String();
				
				if (joueur[(Jeu.getIndicePremierJoueurEnchere()+(i-1)/2)%4].getValeurEnchereJoueur().equals("")){
					str = "";
					string[i+3] += str;
				}
				
				else if (joueur[(Jeu.getIndicePremierJoueurEnchere()+(i-1)/2)%4].getValeurEnchereJoueur().equals("PASSE") && (Jeu.getPasse() != 4)){
					str = "PASSE";
					string[i+3] += str;
				}
				
				else{
					str = joueur[(Jeu.getIndicePremierJoueurEnchere()+(i-1)/2)%4].getValeurEnchereJoueur() + joueur[(Jeu.getIndicePremierJoueurEnchere()+(i-1)/2)%4].getCouleurEnchereJoueur();
					if (Jeu.getIsCoinche()) str += "*";
					if (Jeu.getIsSurCoinche()) str += "*";
					string[i+3] += str;
				}
				
				if (i==1){
					String str2= new String();
					for (int k=0; k< 39 - str.length(); k++){
						string[i+3] += " ";
					}
					str2 = Integer.toString(joueur[0].getNombrePointsEquipe());
					string[i+3] += str2;
					for (int k=0; k< 11 - str2.length(); k++){
						string[i+3] += " ";
					}
					
					string[i+3] += "||        " + Integer.toString(joueur[1].getNombrePointsEquipe());
					
				}
				
			}

			
			string[i+3] += "\n";
		}
		
		string[11] = "      ";
		if (cache==true){
			for (int i=0; i<8; i++)
			{
				if (joueur[0].getPoignee().size() > i)
					string[11] += " \u2588  ";
				else
					string[11] += "   ";
			}
		}
		else{
			for (int i=0; i<8; i++)
			{
				if (joueur[0].getPoignee().size() > i){
					//string[11] += joueur[0].getPoignee().elementAt(i).affichage(indiceJoueurCourant==joueur[0].getOrdreJoueur()) + " ";
					string[11] += joueur[0].getPoignee().elementAt(i).affichage() + " ";
				}
				else
					string[11] += "   ";
			}
		}
		string[11] += "\n";
		
		string[12] = "\n";
		string[13] = "                   JOUEUR 1\n";
		
		
		retour = "\n\n";
		for(int i=0; i<14; i++){
			retour += string[i];
		}
		retour += "\n" + belote + "\n\n";
		
		return retour;
		
	}
	

}




