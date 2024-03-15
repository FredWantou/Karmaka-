package Model.Joueur;

import Model.Cards.AnneauKarmique;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAnneauxKarmique implements Serializable{

    // =============================================== LES ATTRIBUTS ============================================ //
    List<AnneauKarmique> reserveDAnneaux;

    // ============================================ LE CONSTRUCTEUR ============================================ //
    public ReserveDAnneauxKarmique() {
        reserveDAnneaux = new ArrayList<AnneauKarmique>();
    }

    // =============================================== LES GETTERS ============================================ //
    public List<AnneauKarmique> getReserveDAnneaux() {
        return reserveDAnneaux;
    }

    public int getNombreDAnneaux() {
        return reserveDAnneaux.size();
    }

    // =============================================== LES METHODES ============================================ //


    // ========================================== ADD & REMOVE ========================================= //
    public void addAnneauKarmique(AnneauKarmique anneauKarmique) {
        reserveDAnneaux.add(anneauKarmique);
    }

    public void removeAnneauKarmique() {
        reserveDAnneaux.remove(0);
    }
}
