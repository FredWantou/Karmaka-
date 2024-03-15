package Model.Partie;

import java.io.Serializable;

public enum EtatDeLaPartie implements Serializable{

    CREATING, PLAYERS_ADDED,
    JOUEUR_REEL_PLAYING, CPU_1_PLAYING, CPU_2_PLAYING, FINISHED;

    @Override
    public String toString() {
        if (this == CREATING) {
            return "CREATING...";
        }
        else if (this == PLAYERS_ADDED) {
            return "PLAYER_ADDED...";
        }
        else if (this == JOUEUR_REEL_PLAYING) {
            return "JOUEUR_REEL_PLAYING...";
        }
        else if (this == CPU_1_PLAYING) {
            return "CPU_1_PLAYING";
        }
        else if (this == CPU_2_PLAYING) {
            return "CPU_2_PLAYING";
        }
        else {
            return "FINISHED...";
        }
    }
}
