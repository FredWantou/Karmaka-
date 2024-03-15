package Model.ReservesDeCartes;

import Model.Cards.Card;

import java.util.LinkedList;
import java.util.List;

/**
 * @author giovannizangue
 * <br>
 * La fosse est l'endroit où seront jetées le cartes déja utilisée.
 * <br>
 * Etant donnée qu'il n'existe qu'une seule Model.ReservesDeCartes.Fosse on va utiliser le <b>SINGLETON PATTERN</b>
 */
public class Fosse extends ReserveDeCartes {

    // =============================================== LES ATTRIBUTS ============================================ //
    private static Fosse fosse = new Fosse();


    // =========================================== LE CONSTRUCTEUR ========================================= //
    private Fosse() {
        this.reserve = reserve;
    }

    public static Fosse Fosse() {
        if (fosse == null) {
            fosse = new Fosse();
            return fosse;
        }
        else {
            return fosse;
        }
    }

    // =========================================== LES METHODES ========================================= //
    // =========================================== AJOUTER CARTE ========================================= //

    public void addCard(Card carte) {
        reserve.add(carte);
    }


}
