package peter.echec.model;

import peter.echec.model.pieces.Piece;

public class Case {

	private Piece piece;

	public Case(Piece piece) {
		super();
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
