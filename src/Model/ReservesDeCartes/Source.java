package Model.ReservesDeCartes;

import Model.Cards.Card;
import Model.Cards.CardsSpecifiques23.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author giovannizangue
 * <br>
 * La fosse est l'endroit où seront jetées le cartes déja utilisée.
 * <br>
 * Etant donnée qu'il n'existe qu'une seule Soucre on va utiliser le <b>SINGLETON PATTERN</b>
 */
public class Source extends ReserveDeCartes {

    // =============================================== LES ATTRIBUTS ============================================ //
    private static Source source = new Source();

    // =========================================== LE CONSTRUCTEUR ========================================= //

    /**
     * On initialise La source avec l'ensemble des 64 cartes du jeu
     * <br>
     */
    private Source() {
        reserve.add(new Bassesse());
        reserve.add(new Bassesse());
        reserve.add(new CoupDOeil());
        reserve.add(new CoupDOeil());
        reserve.add(new CoupDOeil());
        reserve.add(new Crise());
        reserve.add(new Crise());
        reserve.add(new Crise());
        reserve.add(new Deni());
        reserve.add(new Deni());
        reserve.add(new Deni());
        reserve.add(new DernierSouffle());
        reserve.add(new DernierSouffle());
        reserve.add(new DernierSouffle());
        reserve.add(new Destinee());
        reserve.add(new Destinee());
        reserve.add(new Destinee());
        reserve.add(new Duperie());
        reserve.add(new Duperie());
        reserve.add(new Fournaise());
        reserve.add(new Fournaise());
        reserve.add(new Fournaise());
        reserve.add(new Incarnation());
        reserve.add(new Incarnation());
        reserve.add(new Incarnation());
        reserve.add(new Incarnation());
        reserve.add(new Incarnation());
        reserve.add(new Jubile());
        reserve.add(new Jubile());
        reserve.add(new Lendemain());
        reserve.add(new Lendemain());
        reserve.add(new Lendemain());
        reserve.add(new Longevite());
        reserve.add(new Longevite());
        reserve.add(new Longevite());
        reserve.add(new Mimetisme());
        reserve.add(new Mimetisme());
        reserve.add(new Panique());
        reserve.add(new Panique());
        reserve.add(new Panique());
        reserve.add(new Recyclage());
        reserve.add(new Recyclage());
        reserve.add(new Recyclage());
        reserve.add(new RevesBrises());
        reserve.add(new RevesBrises());
        reserve.add(new RevesBrises());
        reserve.add(new Roulette());
        reserve.add(new Roulette());
        reserve.add(new Roulette());
        reserve.add(new Sauvetage());
        reserve.add(new Sauvetage());
        reserve.add(new Sauvetage());
        reserve.add(new Semis());
        reserve.add(new Semis());
        reserve.add(new Semis());
        reserve.add(new Transmigration());
        reserve.add(new Transmigration());
        reserve.add(new Transmigration());
        reserve.add(new Vengeance());
        reserve.add(new Vengeance());
        reserve.add(new Vol());
        reserve.add(new Vol());
        reserve.add(new Voyage());
        reserve.add(new Voyage());

        this.reserve = reserve;
    }

    public static Source Source() {
        if (source == null) {
            source = new Source();
            return source;
        } else {
            return source;
        }
    }

    // =========================================== LES GETTERS ========================================= //

    // =========================================== GET_SIZE ========================================= //
    public int getSize() {
        return reserve.size();
    }

    // =========================================== TO_STRING ========================================= //

    @Override
    public String toString() {
        return "" + reserve + "";
    }

    // =========================================== LES METHODES ========================================= //
    // =========================================== MELANGER LES CARTES ========================================= //
    public void melanger() {
        Random random = new Random();
        for (int i=0; i<reserve.size(); i++) {
            Collections.swap(reserve, i, random.nextInt(reserve.size()));
        }
    }

    // =========================================== ADD_CARD ========================================= //
    public void addCard(Card card) {
        reserve.add(card);
    }

    // =========================================== REMOVE_CARD ========================================= //
    public Card removeCard() {
        return reserve.remove(0);
    }

}
