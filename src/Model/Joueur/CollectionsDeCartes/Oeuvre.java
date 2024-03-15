package Model.Joueur.CollectionsDeCartes;

import Model.Cards.Card;
import Model.Cards.Couleur;
import Model.ReservesDeCartes.Source;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author giovannizangue
 * Cette classe correspond à l'oeuvre du Model.Joueur
 */
public class Oeuvre extends CollectionDeCartes{

    // =============================================== LES ATTRIBUTS ========================================= //
    private List<Card> cartesDeLOeuvre;

    private int nbreDePointsBleu = 0;
    private int nbreDePointsVert = 0;
    private int nbreDePointRouge = 0;
    private int nbreDePointsMosaique = 0;

    // ============================================= LE CONSTRUCTEUR ========================================= //
    public Oeuvre() {
        cartesDeLOeuvre = new ArrayList<Card>();
    }

    // =============================================== LES GETTERS ============================================ //
    public List<Card> getCartesDeLOeuvre() {
        return cartesDeLOeuvre;
    }


    // ========================================= LES METHODES ============================================ //

    // ========================================= ADD & REMOVE ============================================ //
    @Override
    public void addCard(Card carte) {
        cartesDeLOeuvre.add(carte);

       /* if (carte.getCouleur() == Couleur.BLEU)
            nbreDePointsBleu += carte.getPoint();
        if (carte.getCouleur() == Couleur.ROUGE)
            nbreDePointRouge += carte.getPoint();
        if (carte.getCouleur() == Couleur.VERT)
            nbreDePointsVert += carte.getPoint();

        */
    }

    @Override
    public Card removeCard() {
        return cartesDeLOeuvre.remove(0);
    }

    // ================================= CALCULER NOMBRE DE POINTS ======================================= //
    public int CalculerNombreDePoints() {
        int nombreDePoints = 0;

        for (Card carte : getCartesDeLOeuvre()){
            if (carte.getCouleur() == Couleur.BLEU)
                nbreDePointsBleu += carte.getPoint();
            if (carte.getCouleur() == Couleur.ROUGE)
                nbreDePointRouge += carte.getPoint();
            if (carte.getCouleur() == Couleur.VERT)
                nbreDePointsVert += carte.getPoint();
        }

        nombreDePoints = Math.max(nbreDePointsVert, Math.max(nbreDePointRouge, nbreDePointsBleu));

        return nombreDePoints;
    }
    
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Oeuvre:");
		Iterator<Card> it = cartesDeLOeuvre.iterator();
    	while(it.hasNext()) {
    		Card carte = it.next();
    		builder.append(carte.getNom()+" : "+carte.getPoint()+", "+carte.getCouleur()+"\n");
    	}
		return builder.toString();
	}

}
