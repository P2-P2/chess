package peter.echec.model.pieces;

import peter.echec.model.Case;

public class Pion extends Piece {

	public Pion(String nom, int color, String imagePath) {
		super(nom, color, imagePath);
	}

	@Override
	public int[][] deplacement(Case[][] plateau, int ligne, int colonne) {

		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[i][j] = 0;
			}
		}

		// Déplacement des blanc (vers le haut)
		if (getColor() == 0) {

			// Départ déplacement de deux cases
			if (ligne == 6 && plateau[ligne - 1][colonne].getPiece() == null
					&& plateau[ligne - 2][colonne].getPiece() == null) {
				result[ligne - 2][colonne] = 1;
			}

			// Déplacement normal avant la dernière ligne
			if (ligne > 0 && plateau[ligne - 1][colonne].getPiece() == null) {
				result[ligne - 1][colonne] = 1;
			}

			// Manger une pièce à gauche
			if (ligne > 0 && colonne > 0 && plateau[ligne - 1][colonne - 1].getPiece() != null
					&& plateau[ligne - 1][colonne - 1].getPiece().getColor() != getColor()) {
				result[ligne - 1][colonne - 1] = 1;
			}

			// Manger une pièce à droite
			if (ligne > 0 && colonne < 7 && plateau[ligne - 1][colonne + 1].getPiece() != null
					&& plateau[ligne - 1][colonne + 1].getPiece().getColor() != getColor()) {
				result[ligne - 1][colonne + 1] = 1;
			}
		} else {

			// Départ déplacement de deux cases
			if (ligne == 1 && plateau[ligne + 1][colonne].getPiece() == null
					&& plateau[ligne + 2][colonne].getPiece() == null) {
				result[ligne + 2][colonne] = 1;
			}

			// Déplacement normal avant la dernière ligne
			if (ligne < 7 && plateau[ligne + 1][colonne].getPiece() == null) {
				result[ligne + 1][colonne] = 1;
			}

			// Manger une pièce à gauche
			if (ligne < 7 && colonne > 0 && plateau[ligne + 1][colonne - 1].getPiece() != null
					&& plateau[ligne + 1][colonne - 1].getPiece().getColor() != getColor()) {
				result[ligne + 1][colonne - 1] = 1;
			}

			// Manger une pièce à droite
			if (ligne < 7 && colonne < 7 && plateau[ligne + 1][colonne + 1].getPiece() != null
					&& plateau[ligne + 1][colonne + 1].getPiece().getColor() != getColor()) {
				result[ligne + 1][colonne + 1] = 1;
			}
		}

		return result;
	}

}
