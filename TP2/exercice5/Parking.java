package exercice5;
import java.util.*;
public class Parking {
    int PlacesOccupees; 
    int Capacite ; 
    public HashSet<Voiture> infoVoitures = new HashSet<Voiture>();
    Parking(int size){ this.Capacite = size;} 
    int places(){ return (this.Capacite - this.PlacesOccupees); }  
	
    synchronized boolean  accept(Voiture myVoit) {
	if  (this.places() >0 )
	    { 
		this.PlacesOccupees ++ ;
		infoVoitures.add(myVoit); 
		System.out.format("[Parking] :%s acceptee, il reste %d places \n", myVoit.nom, this.places());
		System.out.format("Voiture Garees\n");
		System.out.println(infoVoitures);
		return (true) ; 
	    }
	else {
	    System.out.format("Parking : %s refusee, il reste  %d places \n", myVoit.nom,this.places());
	    return(false) ;
	}
    }
    synchronized void leave(Voiture myVoit) {
	PlacesOccupees --; 
	infoVoitures.remove(myVoit);
	System.out.format("Parking :[%s] est sortie, reste  %d places\n", myVoit.nom, places());
    }}
