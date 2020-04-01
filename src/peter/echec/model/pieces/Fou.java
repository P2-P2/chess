package peter.echec.model.pieces;

import javafx.scene.image.Image;
import peter.echec.model.Case;

public class Fou extends Piece{

	public Fou(String nom, int color, Image image) {
		super(nom, color, image);
		// TODO Auto-generated constructor stub
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
		
		return result;
	}
	
	private boolean checkCase(Case[][] plateau, int ligne, int colonne) {
		return plateau[ligne][colonne].getPiece() == null || plateau[ligne][colonne].getPiece().getColor() != getColor();
	}
}
