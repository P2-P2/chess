package peter.echec.model;

import java.util.ArrayList;

public class Partie {

	private Plateau plateau;
	private ArrayList<Deplacement> deplacements;

	// tour = 1 au blanc, tour = 0 au noir
	private int tour;

	public Partie() {

		plateau = new Plateau();

		nouvellePartie();
	}

	public Plateau getPlateau() {

		return plateau;
	}

	public void nouvellePartie() {
		plateau.initPlateau();
		deplacements = new ArrayList<>();
		// Les blancs commencent la partie
		tour = 0;
	}

	public boolean deplacement(Case caseSelectionnee, Case nouvelleCase) {

		deplacements.add(
				new Deplacement(caseSelectionnee, nouvelleCase, caseSelectionnee.getPiece(), nouvelleCase.getPiece()));

		boolean finDePartie = nouvelleCase.getPiece() != null && nouvelleCase.getPiece().getNom().equals("Roi");

		plateau.deplacement(caseSelectionnee, nouvelleCase);

		tour = tour == 0 ? 1 : 0;
		return finDePartie;
	}

	public void annulerDeplacement() {
		if (deplacements.size() > 0) {

			Deplacement dernierDeplacement = deplacements.get(deplacements.size() - 1);
			dernierDeplacement.getCaseInitiale().setPiece(dernierDeplacement.getPieceDeplacee());
			dernierDeplacement.getNouvelleCase().setPiece(dernierDeplacement.getPieceMangee());

			deplacements.remove(dernierDeplacement);
			tour = tour == 0 ? 1 : 0;
		}
	}

	public int getTour() {
		return tour;
	}
}
