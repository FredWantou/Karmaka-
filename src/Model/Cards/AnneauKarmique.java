package Model.Cards;

import java.io.Serializable;

import Exceptions.MaximumAnneauKarmiqueException;

/**
 * @author giovannizangue
 * <br>
 * Cette classe correspond aux <b>Anneaux Karmiques</b>
 */
public class AnneauKarmique  implements Serializable{

    // =============================================== LES ATTRIBUTS ========================================== //
    private final int points = 1;
    private static int nombreDAnneaux = 0;
    private static final int LIMITE_MAXIMALE = 12;


    // ============================================ LE CONSTRUCTEUR ========================================= //
    public AnneauKarmique() throws MaximumAnneauKarmiqueException {
        if (nombreDAnneaux == LIMITE_MAXIMALE) {
            throw new MaximumAnneauKarmiqueException("IMPOSSIBLE DE CREER PLUS DE 12 ANNEAUX KARMIQUE\n");
        }
        nombreDAnneaux ++;
    }


    // ============================================ LES METHODES ========================================= //
    public int getPoints() {

        return points;
    }

    @Override
    public String toString() {
        return "anneauKarmique";
    }
}
