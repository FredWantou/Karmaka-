package Model.Joueur.CollectionsDeCartes;

import Model.Cards.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author giovannizangue
 * <br>
 * Cette classe abstraite est la classe mere des collections de cartes que possede le jouer <b>Main,
 * Pile, Oeuvre, VieFuture</b>
 */
public abstract class CollectionDeCartes implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private static int nombreDeCartes;
    // ====================================== LES ATTRIBUTS ============================================ //
    private List<Card> listeDeCartes = new ArrayList<>();

    // ====================================== LES GETTERS ET SETTERS ========================================== //
    protected void setNombreDeCartes(int nbre) {
        nombreDeCartes = nbre;
    }
    
    /*public int getNombredeCarte() {
    	return this.nombreDeCartes;
    }*/

    // ========================================= LE CONSTRUCTEUR ============================================ //


    // ========================================= LES METHODES ============================================ //
    public abstract void addCard(Card carte);

    public abstract Card removeCard();
    protected void decrementNombreDeCartes() {
        nombreDeCartes -= 1;
    }

    protected void incrementNombreDeCartes() {
        nombreDeCartes += 1;
    }


}
