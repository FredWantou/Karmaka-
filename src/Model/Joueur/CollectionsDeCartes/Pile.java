package Model.Joueur.CollectionsDeCartes;

import Model.Cards.Card;
import Model.ReservesDeCartes.Source;

import java.util.ArrayList;
import java.util.List;

/**
 * @author giovannizangue
 * Cette classe correspond à la pile du Model.Joueur
 */
public class Pile extends CollectionDeCartes{

    // =============================================== LES ATTRIBUTS ============================================ //
    private List<Card> cartesDeLaPile;

    // ============================================= LE CONSTRUCTEUR ============================================ //
    public Pile() {
        cartesDeLaPile = new ArrayList<Card>();
    }

    // =============================================== LES GETTERS ============================================ //
    public List<Card> getCartesDeLaPile() {
        setNombreDeCartes(2);
        return cartesDeLaPile;
    }


    // =============================================== LES METHODES ============================================ //
    @Override
    public void addCard(Card carte) {
        cartesDeLaPile.add(carte);
    }
    @Override
    public Card removeCard() {
        return cartesDeLaPile.remove(0);
    }
}
