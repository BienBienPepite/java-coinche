package main;
import java.util.*;


public class Paquet {
	
	protected Stack<Carte> tas = new Stack<Carte>();
	
	public Paquet(){
		
		//for (int i=0 ; i<4 ; i++)
		for (Couleur cou : Couleur.values())
		{
			if (!cou.equals(Couleur.AUCUNE)){
			//for (int j=0; j<8 ; j++)
				for (Valeur val : Valeur.values())
				{
					if (!val.equals(Valeur.AUCUNE))
						tas.push(new Carte(val,cou));
					//tas.push(new Carte(Valeur.values()[j],Couleur.values()[i]));
				}
			}
		}
	}
	
	public Stack<Carte> getTas(){
		
		return this.tas;
	}

	public void melanger(){
		Collections.shuffle(this.tas);
	}
	
	public void depiler(){
		int i =0;
		while(!this.tas.empty())
		{
			i++;
			Carte carte = this.tas.pop();
			carte.afficher(); System.out.print(" " + i + "\n");
		}
	}
	
	public void distribuer(Joueur[] joueur){
		for (int j=0; j<4; j++){
			for(int i=0; i<8; i++)
			{
				joueur[j].ajouterCarte(this.tas.peek());
				this.tas.pop();
			}
		}
			
		
	}

}
