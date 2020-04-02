package peter.echec.model.pieces;

import peter.echec.model.Case;

public class Cavalier extends Piece {

	public Cavalier(String nom, int color, String imagePath) {
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

		// Déplacement haut x 2 + droite x 1
		if (colonne - 2 >= 0 && ligne + 1 <= 7 && checkCase(plateau, ligne + 1,colonne - 2)) {
			result[ligne + 1][colonne - 2] = 1;
		}

		// Déplacement droite x 2 + haut x 1
		if (colonne - 1 >= 0 && ligne + 2 <= 7 && checkCase(plateau, ligne + 2, colonne - 1)) {
			result[ligne + 2][colonne - 1] = 1;
		}

		// Déplacement doite x 2 + bas x 1
		if (colonne + 1 <= 7 && ligne + 2 <= 7 && checkCase(plateau, ligne + 2,colonne + 1)) {
			result[ligne + 2][colonne + 1] = 1;
		}

		// Déplacement bas x 2 + droite x 1
		if (colonne + 2 <= 7 && ligne + 1 <= 7 && checkCase(plateau, ligne + 1,colonne + 2)) {
			result[ligne + 1][colonne + 2] = 1;
		}

		// Déplacement bas x 2 + gauche x 1
		if (colonne + 2 <= 7 && ligne - 1 >= 0 && checkCase(plateau, ligne - 1,colonne + 2)) {
			result[ligne - 1][colonne + 2] = 1;
		}

		// Déplacement gauche x 2 + bas x 1
		if (colonne + 1 <= 7 && ligne - 2 >= 0 && checkCase(plateau, ligne - 2,colonne + 1)) {
			result[ligne - 2][colonne + 1] = 1;
		}

		// Déplacement gauche x 2 + haut x 1
		if (colonne - 1 >= 0 && ligne - 2 >= 0 && checkCase(plateau, ligne - 2,colonne - 1)) {
			result[ligne - 2][colonne - 1] = 1;
		}

		// Déplacement haut x 2 + gauche x 1
		if (colonne - 2 >= 0 && ligne - 1 >= 0 && checkCase(plateau, ligne - 1, colonne - 2)) {
			result[ligne - 1][colonne - 2] = 1;
		}

		return result;
	}
	
	private boolean checkCase(Case[][] plateau, int ligne, int colonne) {
		return plateau[ligne][colonne].getPiece() == null || plateau[ligne][colonne].getPiece().getColor() != getColor();
	}

}
