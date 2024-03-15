package Model.Partie;
import java.io.*;

public class SauvegardePartie {
	public static void sauvegardePartie(Partie partie, String fichier) {
		try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(fichier))){
			oos.writeObject(partie);
			System.out.println("Partie sauvegradée avec succès !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
