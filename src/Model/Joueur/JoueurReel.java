package Model.Joueur;

/**
 * @author giovannizangue
 * <br>
 * Cette classe est une specialisation de la classe joueur. Elle est specifique au <b>Model.Joueur Reel</b>
 * (toi, moi, etc...)
 */
public class JoueurReel extends Joueur {


	// ====================================== LE CONSTRUCTEUR ============================================ //
	public JoueurReel(String pseudo) {
		super.setPseudo(pseudo);
		super.setNiveau(Niveau.BOUSIER);
	}

	@Override
	public String toString() {
		return "JoueurReel{" +
				"•Pseudo = " + super.getPseudo() +
				"  •Niveau = " + super.getNiveau() +
				"  •Main = " + super.getMain().getCartesDeLaMain() +
				"  •Oeuvre = " + super.getOeuvre().getCartesDeLOeuvre() +
				"  •Pile = " + super.getPile().getCartesDeLaPile() +
				"  •Vie Future = " + super.getVieFuture().getCartesDeLaVieFuture() +
				"  •Reserve d'Anneaux Karmique = " + super.getReserveDAnneauxKarmique().getReserveDAnneaux() +
				"}";
	}
}
