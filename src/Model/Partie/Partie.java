package Model.Partie;

import Model.Joueur.Joueur;
import Model.Joueur.JoueurVirtuel;
import Model.Joueur.OptionDeJeu;
import Model.ReservesDeCartes.Fosse;
import Model.ReservesDeCartes.Source;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * @author giovannizangue
 * <br>
 * Cette classe est la 1ere classe du jeu. C'est a partir d'elle que le jeu sera launch.
 * <br>
 * Etant donne qu'il n'existe qu'une seule partie, on va utiliser <b>SINGLETON PATTERN</b>
 */
public class Partie implements Serializable{

    // ====================================== LES ATTRIBUTS ============================================ //
	private static final long serialVersionUID = 1L;
	private static Partie partie;
    Source source;
    Fosse fosse;
    List<Joueur> listeDeJoueurs = new ArrayList<Joueur>();
    private EtatDeLaPartie etatDeLaPartie;
    private TypeDePartie typeDePartie;
    private Joueur gagnant;
    private Joueur activePlayer;
    private Joueur opponentPlayer;


    // ====================================== LES GETTERS ET SETTERS =========================================== //

    // ====================================== LE CONSTRUCTEUR ============================================ //
    private Partie() {
        this.source = Source.Source();
        this.fosse = Fosse.Fosse();
        this.etatDeLaPartie = EtatDeLaPartie.CREATING;
        this.gagnant = null;
    }

    public static Partie getPartie() {
        if (partie == null) {
            partie = new Partie();
            return partie;
        } else {
            return partie;
        }
    }

    // ==================================== LES GETTERS & SETTERS ========================================= //
    public EtatDeLaPartie getEtatDeLaPartie() {
        return etatDeLaPartie;
    }

    public TypeDePartie getTypeDePartie() {
        return typeDePartie;
    }

    public void setTypeDePartie(TypeDePartie typeDePartie) {
        this.typeDePartie = typeDePartie;
    }

    public void setEtatDeLaPartie(EtatDeLaPartie etatDeLaPartie) {
        this.etatDeLaPartie = etatDeLaPartie;

    }
    

    public Joueur getGagnant() {
		return gagnant;
	}

	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}

	public List<Joueur> getListeDeJoueurs() {
        return listeDeJoueurs;
    }

    public Source getSource() {
        return source;
    }

    public Fosse getFosse() {
        return fosse;
    }

    public Joueur getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Joueur activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Joueur getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Joueur opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    // ====================================== LES SETTERS =========================================== //

    public void setFosse(Fosse F) {
    	this.fosse = F;
    }
    
    public void setSource(Source S) {
    	this.source=S;
    }
    
    public void setListeDeJoueurs(List<Joueur> ListeDeJoueurs) {
        this.listeDeJoueurs = ListeDeJoueurs;
    }
    
    
    // ====================================== LES METHODES ============================================ //

    // ================================== AJOUTER_JOUEURS_REEL_VS_CPU ======================================= //
    public void ajouterJoueurReelVsCPU(Joueur joueur) {
        listeDeJoueurs.add(joueur);
        listeDeJoueurs.add(new JoueurVirtuel(1, "CPU")); // On va modifier apres
    }

    // ================================== AJOUTER_JOUEURS_CPU_VS_CPU ======================================= //
    public void ajouterJoueurCPUvsCPU() {
        listeDeJoueurs.add(new JoueurVirtuel(1, "CPU1")); // On va modifier apres
        listeDeJoueurs.add(new JoueurVirtuel(2, "CPU2")); // On va modifier apres
    }


    // ====================================== EST_GAGNEE ============================================ //
    public boolean estGagne() {
        return false;
    }

    // ====================================== DESIGNER_GAGNANT ============================================ //
    public String designerGagnant() {
        return "CPU";    // On va modifier apres.
    }

 // ====================================== SAUVEGARDER PARTIE ========================================//
 // ====================================== SAUVEGARDER PARTIE ========================================//
    public void sauvegarderPartie() {
    	SauvegardePartie.sauvegardePartie(Partie.getPartie(), "Partie.karma");
    }

    // ===================================== CHARGER PARTIE =============================================//
    public void chargerPartie() {
    	partie = ChargementPartie.chargerPartie("Partie.karma");
    }

	public void Deroulement() {
		// TODO Auto-generated method stub
		
	}


}
