
package Model.ReservesDeCartes;

import Model.Cards.Card;

import java.io.Serializable;
import java.util.*;

public abstract class ReserveDeCartes implements Serializable{

    // =============================================== LES ATTRIBUTS ========================================== //
	private static final long serialVersionUID = 1L;
    protected List<Card> reserve = new LinkedList<Card>();
    private static int nombreDeCartes;


    // ============================================ LES GETTRES & SETTRES ===================================== //
    public List<Card> getCartes() {
        return reserve;
    }

    // =============================================== LES METHODES =========================================== //


    //ArrayDeque
}
