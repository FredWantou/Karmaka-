package Model.Joueur;

import java.io.Serializable;

/**
 * @author giovannizangue
 * <br>
 * Cette enumeration contient les niveaux possibles qu'un joueur peut avoir pendant une partie
 */
public enum Niveau implements Serializable{

	
    BOUSIER, SERPENT, LOUP, PRIMATE, TRANSCENDANCE;

    @Override
    public String toString() {
        return switch (this) {
            case BOUSIER -> "BOUSIER";
            case SERPENT -> "SERPENT";
            case LOUP -> "LOUP";
            case PRIMATE -> "PRIMATE";
            case TRANSCENDANCE -> "TRANSCENDANCE";
            default -> "<Niveau non determine>";
        };
    }
}
