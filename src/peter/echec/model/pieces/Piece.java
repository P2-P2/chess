package peter.echec.model.pieces;

import javafx.scene.image.Image;
import peter.echec.model.Case;

public abstract class Piece {

	private Image image;
	private int color;
	private String nom;

	public Piece(String nom, int color, Image image) {
		super();
		this.image = image;
		this.color = color;
		this.nom = nom;
	}

	public Image getImage() {
		return image;
	}
	
	public int getColor() {
		return color;
	}
	
	public abstract int[][] deplacement(Case[][] plateau, int ligne, int colonne);
}
