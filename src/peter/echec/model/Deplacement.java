package peter.echec.model;

import peter.echec.model.pieces.Piece;

public class Deplacement {

	private Case caseInitiale;
	private Case nouvelleCase;
	
	private Piece pieceDeplacee;
	private Piece pieceMangee;
	
	public Deplacement(Case caseInitiale, Case nouvelleCase, Piece pieceDeplacee, Piece pieceMangee) {
		super();
		this.caseInitiale = caseInitiale;
		this.nouvelleCase = nouvelleCase;
		this.pieceDeplacee = pieceDeplacee;
		this.pieceMangee = pieceMangee;
	}

	public Case getCaseInitiale() {
		return caseInitiale;
	}

	public Case getNouvelleCase() {
		return nouvelleCase;
	}

	public Piece getPieceDeplacee() {
		return pieceDeplacee;
	}

	public Piece getPieceMangee() {
		return pieceMangee;
	}
	
	
}
