package peter.echec.model.pieces;

import javafx.scene.image.Image;
import peter.echec.model.Case;

public class Dame extends Piece {

	public Dame(String nom, int color, Image image) {
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

		// Déplacement diag gauche haut
		for (int i = ligne - 1, j = colonne - 1; i >= 0 && j >= 0; i--, j--) {
			if (plateau[i][j].getPiece() == null) {
				result[i][j] = 1;
			} else if (plateau[i][j].getPiece().getColor() != getColor()) {
				result[i][j] = 1;
				break;
			} else {
				break;
			}
		}
		// Déplacement diag gauche bas
		for (int i = ligne + 1, j = colonne - 1; i <= 7 && j >= 0; i++, j--) {
			if (plateau[i][j].getPiece() == null) {
				result[i][j] = 1;
			} else if (plateau[i][j].getPiece().getColor() != getColor()) {
				result[i][j] = 1;
				break;
			} else {
				break;
			}
		}

		// Déplacement diag droite bas
		for (int i = ligne + 1, j = colonne + 1; i <= 7 && j <= 7; i++, j++) {
			if (plateau[i][j].getPiece() == null) {
				result[i][j] = 1;
			} else if (plateau[i][j].getPiece().getColor() != getColor()) {
				result[i][j] = 1;
				break;
			} else {
				break;
			}
		}
		// Déplacement diag droite haut
		for (int i = ligne - 1, j = colonne + 1; i >= 0 && j <= 7; i--, j++) {
			if (plateau[i][j].getPiece() == null) {
				result[i][j] = 1;
			} else if (plateau[i][j].getPiece().getColor() != getColor()) {
				result[i][j] = 1;
				break;
			} else {
				break;
			}
		}

		// Déplacement gauche
		for (int i = colonne - 1; i >= 0; i--) {
			if (plateau[ligne][i].getPiece() == null) {
				result[ligne][i] = 1;
			} else if (plateau[ligne][i].getPiece().getColor() != getColor()) {
				result[ligne][i] = 1;
				break;
			} else {
				break;
			}
		}

		// Déplacement bas
		for (int i = ligne + 1; i <= 7; i++) {
			if (plateau[i][colonne].getPiece() == null) {
				result[i][colonne] = 1;
			} else if (plateau[i][colonne].getPiece().getColor() != getColor()) {
				result[i][colonne] = 1;
				break;
			} else {
				break;
			}
		}

		// Déplacement droite
		for (int i = colonne + 1; i <= 7; i++) {
			if (plateau[ligne][i].getPiece() == null) {
				result[ligne][i] = 1;
			} else if (plateau[ligne][i].getPiece().getColor() != getColor()) {
				result[ligne][i] = 1;
				break;
			} else {
				break;
			}
		}
		// Déplacement haut
		for (int i = ligne - 1; i >= 0; i--) {
			if (plateau[i][colonne].getPiece() == null) {
				result[i][colonne] = 1;
			} else if (plateau[i][colonne].getPiece().getColor() != getColor()) {
				result[i][colonne] = 1;
				break;
			} else {
				break;
			}
		}

		return result;
	}

}
