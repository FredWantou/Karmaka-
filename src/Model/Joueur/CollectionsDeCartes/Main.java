package Model.Joueur.CollectionsDeCartes;


import Model.Cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author giovannizangue
 * Classe de la qui correspond à la main du Model.Joueur
 */
public class Main extends CollectionDeCartes {

    // =============================================== LES ATTRIBUTS ============================================ //
    private List<Card> cartesDeLaMain;

    // ============================================ LE CONSTRUCTEUR ============================================ //
    public Main() {
        cartesDeLaMain = new ArrayList<Card>();
    }

    // =============================================== LES GETTERS ============================================ //
    public List<Card> getCartesDeLaMain() {
        setNombreDeCartes(5);
        return cartesDeLaMain;
    }

    // =============================================== LES METHODES ============================================ //


    // ========================================== ADD_CARD & REMOVE_CARD ========================================= //
    @Override
    public void addCard(Card carte) {
        cartesDeLaMain.add(carte);
    }
    /*@Override
	public String toString() {
		return "Main";
	}*/
    
    
    public void AfficheMain() {
    	System.out.println("Main");
    	Iterator<Card> it = cartesDeLaMain.iterator();
    	while(it.hasNext()) {
    		Card carte = it.next();
    		System.out.println(carte.getNom()+" : "+carte.getPoint());
    	}
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Main:");
		Iterator<Card> it = cartesDeLaMain.iterator();
    	while(it.hasNext()) {
    		Card carte = it.next();
    		builder.append(carte.getNom()+" : "+carte.getPoint()+", "+carte.getCouleur()+"\n");
    	}
		return builder.toString();
	}

	@Override
    public Card removeCard() {
        return cartesDeLaMain.remove(0);
    }


}
