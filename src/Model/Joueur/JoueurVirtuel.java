package Model.Joueur;

import Model.Joueur.CollectionsDeCartes.Main;
import Model.Joueur.CollectionsDeCartes.Oeuvre;
import Model.Joueur.CollectionsDeCartes.Pile;
import Model.Joueur.CollectionsDeCartes.VieFuture;

/**
 * @author giovannizangue
 * <br>
 * Cette classe est une specialisation de la classe Jouer. Elle correspond au <b>Model.Joueur Virtuel</b> (Le CPU)
 */
public class JoueurVirtuel extends Joueur{

    private int strategie;
    private String nom;

    // ====================================== LE CONSTRUCTEUR ============================================ //
    public JoueurVirtuel(int strategie, String nom) {
        super.setNiveau(Niveau.BOUSIER);
        this.strategie = strategie;
        super.setPseudo(nom);
    }

    // ===================================== GETTERS & SETTERS ======================================= //
    public int getStrategie() {
        return strategie;
    }

    public void setStrategie(int strategie) {
        this.strategie = strategie;
    }



    // ===================================== TO_STRING ======================================= //
    @Override
    public String toString() {
        return "JoueurVirtuel{" +
                "•Pseudo = " + super.getPseudo()+
                "  •Niveau = " + super.getNiveau() +
                "  •Main = " + super.getMain().getCartesDeLaMain() +
                "  •Oeuvre = " + super.getOeuvre().getCartesDeLOeuvre() +
                "  •Pile = " + super.getPile().getCartesDeLaPile() +
                "  •Vie Future = " + super.getVieFuture().getCartesDeLaVieFuture() +
                "  •Reserve d'Anneaux Karmique = " + super.getReserveDAnneauxKarmique().getReserveDAnneaux() +
                "}";
    }

    // Strategie // Faire jouer 02 jouers virtuels en meme temps
}
