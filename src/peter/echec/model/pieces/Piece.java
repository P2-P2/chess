package peter.echec.model.pieces;

import peter.echec.model.Case;

public abstract class Piece {

	private String imagePath;
	private int color;
	private String nom;

	public Piece(String nom, int color, String imagePath) {
		super();
		
		this.nom = nom;
		this.color = color;
		this.imagePath = imagePath;
	}
	
	public int getColor() {
		return color;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getNom() {
		return nom;
	}
	
	public abstract int[][] deplacement(Case[][] plateau, int ligne, int colonne);
}
