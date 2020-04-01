package peter.echec.model.pieces;

import javafx.scene.image.Image;
import peter.echec.model.Case;

public class Roi extends Piece {

	public Roi(String nom, int color, Image image) {
		super(nom, color, image);
	}

	@Override
	public int[][] deplacement(Case[][] plateau, int ligne, int colonne) {
		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[i][j] = 0;
			}
		}

		// Déplacement gauche
		if (colonne - 1 >= 0 && checkCase(plateau, ligne, colonne - 1)) {
			result[ligne][colonne - 1] = 1;
		}

		// Déplacement gauche - bas
		if (colonne - 1 >= 0 && ligne + 1 <= 7 && checkCase(plateau, ligne + 1, colonne - 1)) {
			result[ligne + 1][colonne - 1] = 1;
		}

		// Déplacement bas
		if (ligne + 1 <= 7 && checkCase(plateau, ligne + 1, colonne)) {
			result[ligne + 1][colonne] = 1;
		}

		// Déplacement bas - droite
		if (ligne + 1 <= 7 && colonne + 1 <= 7 && checkCase(plateau, ligne + 1, colonne + 1)) {
			result[ligne + 1][colonne + 1] = 1;
		}

		// Déplacement droite
		if (colonne + 1 <= 7 && checkCase(plateau, ligne, colonne + 1)) {
			result[ligne][colonne + 1] = 1;
		}

		// Déplacement droite - haut
		if (colonne + 1 <= 7 && ligne - 1 >= 0 && checkCase(plateau, ligne - 1, colonne + 1)) {
			result[ligne - 1][colonne + 1] = 1;
		}

		// Déplacement haut
		if (ligne - 1 >= 0 && checkCase(plateau, ligne - 1, colonne)) {
			result[ligne - 1][colonne] = 1;
		}

		// Déplacement haut - gauche
		if (colonne - 1 >= 0 && ligne - 1 >= 0 && checkCase(plateau, ligne - 1, colonne - 1)) {
			result[ligne - 1][colonne - 1] = 1;
		}

		return result;
	}

	private boolean checkCase(Case[][] plateau, int ligne, int colonne) {
		return plateau[ligne][colonne].getPiece() == null
				|| plateau[ligne][colonne].getPiece().getColor() != getColor();
	}

}
