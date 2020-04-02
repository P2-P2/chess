package peter.echec.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import peter.echec.model.pieces.*;

public class Plateau {

	private Case[][] cases;

	private List<Piece> piecesNoirs;
	private List<Piece> piecesBlanches;

	public Plateau() {
		cases = new Case[8][8];

		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases.length; j++) {
				cases[i][j] = new Case(null);
			}
		}

		piecesNoirs = new ArrayList<>();
		piecesBlanches = new ArrayList<>();

		// Création des pièces Noirs
		piecesNoirs.add(new Tour("Tour", 1, "File:images/tour_n.png"));
		piecesNoirs.add(new Cavalier("Cavalier", 1, "File:images/cavalier_n.png"));
		piecesNoirs.add(new Fou("Fou", 1, "File:images/fou_n.png"));
		piecesNoirs.add(new Dame("Dame", 1, "File:images/dame_n.png"));
		piecesNoirs.add(new Roi("Roi", 1, "File:images/roi_n.png"));
		piecesNoirs.add(new Fou("Fou", 1, "File:images/fou_n.png"));
		piecesNoirs.add(new Cavalier("Cavalier", 1, "File:images/cavalier_n.png"));
		piecesNoirs.add(new Tour("Tour", 1, "File:images/tour_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));
		piecesNoirs.add(new Pion("Pion", 1, "File:images/pion_n.png"));

		// Création des pièces Blanches
		piecesBlanches.add(new Tour("Tour", 0, "File:images/tour_b.png"));
		piecesBlanches.add(new Cavalier("Cavalier", 0, "File:images/cavalier_b.png"));
		piecesBlanches.add(new Fou("Fou", 0, "File:images/fou_b.png"));
		piecesBlanches.add(new Dame("Dame", 0, "File:images/dame_b.png"));
		piecesBlanches.add(new Roi("Roi", 0, "File:images/roi_b.png"));
		piecesBlanches.add(new Fou("Fou", 0, "File:images/fou_b.png"));
		piecesBlanches.add(new Cavalier("Cavalier", 0, "File:images/cavalier_b.png"));
		piecesBlanches.add(new Tour("Tour", 0, "File:images/tour_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));
		piecesBlanches.add(new Pion("Pion", 0, "File:images/pion_b.png"));

		// Initialisation du plateau
		initPlateau();
	}

	public void initPlateau() {

		for (int i = 0; i < 8; i++)
			cases[0][i].setPiece(piecesNoirs.get(i));

		for (int i = 0; i < 8; i++)
			cases[1][i].setPiece(piecesNoirs.get(i + 8));

		for (int i = 0; i < 8; i++)
			cases[6][i].setPiece(piecesBlanches.get(i + 8));

		for (int i = 0; i < 8; i++)
			cases[7][i].setPiece(piecesBlanches.get(i));
	}

	public void deplacement(Case caseSelectionnee, Case nouvelleCase) {

		nouvelleCase.setPiece(caseSelectionnee.getPiece());
		caseSelectionnee.setPiece(null);
	}

	public Case getCase(int i, int j) {

		return cases[i][j];
	}

	public Case[][] getCases() {
		return cases;
	}

	public List<Piece> getPiecesBlanches() {
		return piecesBlanches;
	}

	public List<Piece> getPiecesNoirs() {
		return piecesNoirs;
	}

	public int[][] deplacementPossible(int ligne, int colonne) {

		return cases[ligne][colonne].getPiece().deplacement(cases, ligne, colonne);
	}

}
