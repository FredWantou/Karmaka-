package Model.Partie;

import java.io.*;

public class ChargementPartie {
	public static Partie chargerPartie(String fichier) {
		Partie partie = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))){
			partie = (Partie) ois.readObject();
			System.out.println("Partie chargée avec succès !");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return partie;
	}
}
