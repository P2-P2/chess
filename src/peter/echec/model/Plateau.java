package peter.echec.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import peter.echec.model.pieces.*;

public class Plateau {

	private Case[][] plateau;

	private List<Piece> piecesNoirs;
	private List<Piece> piecesBlanches;

	private Case caseSelectionnee;
	
	public Plateau() {
		plateau = new Case[8][8];

		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(null);
			}
		}

		piecesNoirs = new  ArrayList<>();
		piecesBlanches = new  ArrayList<>();

		// Création des pièces Noirs
		piecesNoirs.add(new Tour("Tour", 1, new Image("File:images/tour_n.png")));
		piecesNoirs.add(new Cavalier("Cavalier", 1, new Image("File:images/cavalier_n.png")));
		piecesNoirs.add(new Fou("Fou", 1, new Image("File:images/fou_n.png")));
		piecesNoirs.add(new Dame("Dame", 1, new Image("File:images/dame_n.png")));
		piecesNoirs.add(new Roi("Roi", 1, new Image("File:images/roi_n.png")));
		piecesNoirs.add(new Fou("Fou", 1, new Image("File:images/fou_n.png")));
		piecesNoirs.add(new Cavalier("Cavalier", 1, new Image("File:images/cavalier_n.png")));
		piecesNoirs.add(new Tour("Tour", 1, new Image("File:images/tour_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));
		piecesNoirs.add(new Pion("Pion", 1, new Image("File:images/pion_n.png")));

		// Création des pièces Blanches
		piecesBlanches.add(new Tour("Tour", 0, new Image("File:images/tour_b.png")));
		piecesBlanches.add(new Cavalier("Cavalier", 0, new Image("File:images/cavalier_b.png")));
		piecesBlanches.add(new Fou("Fou", 0, new Image("File:images/fou_b.png")));
		piecesBlanches.add(new Dame("Dame", 0, new Image("File:images/dame_b.png")));
		piecesBlanches.add(new Roi("Roi", 0, new Image("File:images/roi_b.png")));
		piecesBlanches.add(new Fou("Fou", 0, new Image("File:images/fou_b.png")));
		piecesBlanches.add(new Cavalier("Cavalier", 0, new Image("File:images/cavalier_b.png")));
		piecesBlanches.add(new Tour("Tour", 0, new Image("File:images/tour_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		piecesBlanches.add(new Pion("Pion", 0, new Image("File:images/pion_b.png")));
		
		// Initialisation du plateau
		initPlateau();
	}

	public void initPlateau() {

		for (int i = 0; i < 8; i++)
			plateau[0][i].setPiece(piecesNoirs.get(i));

		for (int i = 0; i < 8; i++)
			plateau[1][i].setPiece(piecesNoirs.get(i + 8));

		for (int i = 0; i < 8; i++)
			plateau[6][i].setPiece(piecesBlanches.get(i + 8));

		for (int i = 0; i < 8; i++)
			plateau[7][i].setPiece(piecesBlanches.get(i));
	}

	public Case getCaseSelectionnee() {
		return caseSelectionnee;
	}
	
	public void setCaseSelectionnee(Case caseSelectionnee) {
		this.caseSelectionnee = caseSelectionnee;
	}
	
	public boolean deplacement(Case nouvelleCase) {
		
		return false;
	}
	
	public Case getCase(int i, int j) {

		return plateau[i][j];
	}

	public Case[][] getPlateau() {
		return plateau;
	}

}
