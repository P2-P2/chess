package peter.echec.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import peter.echec.model.Case;
import peter.echec.model.Partie;
import peter.echec.model.pieces.Piece;

public class EchecController implements Initializable {

	@FXML
	private GridPane gridpane;

	@FXML
	private Pane case_0_0, case_0_1, case_0_2, case_0_3, case_0_4, case_0_5, case_0_6, case_0_7;
	@FXML
	private Pane case_1_0, case_1_1, case_1_2, case_1_3, case_1_4, case_1_5, case_1_6, case_1_7;
	@FXML
	private Pane case_2_0, case_2_1, case_2_2, case_2_3, case_2_4, case_2_5, case_2_6, case_2_7;
	@FXML
	private Pane case_3_0, case_3_1, case_3_2, case_3_3, case_3_4, case_3_5, case_3_6, case_3_7;
	@FXML
	private Pane case_4_0, case_4_1, case_4_2, case_4_3, case_4_4, case_4_5, case_4_6, case_4_7;
	@FXML
	private Pane case_5_0, case_5_1, case_5_2, case_5_3, case_5_4, case_5_5, case_5_6, case_5_7;
	@FXML
	private Pane case_6_0, case_6_1, case_6_2, case_6_3, case_6_4, case_6_5, case_6_6, case_6_7;
	@FXML
	private Pane case_7_0, case_7_1, case_7_2, case_7_3, case_7_4, case_7_5, case_7_6, case_7_7;

	@FXML
	private Label labelTurn;

	private Pane[][] panes;

	private Partie partie;

	private Pane firstPaneClicked;
	private Pane secondPaneClicked;

	private Map<Piece, ImageView> piecesImageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		panes = new Pane[8][8];
		Pane[] panes0 = { case_0_0, case_0_1, case_0_2, case_0_3, case_0_4, case_0_5, case_0_6, case_0_7 };
		Pane[] panes1 = { case_1_0, case_1_1, case_1_2, case_1_3, case_1_4, case_1_5, case_1_6, case_1_7 };
		Pane[] panes2 = { case_2_0, case_2_1, case_2_2, case_2_3, case_2_4, case_2_5, case_2_6, case_2_7 };
		Pane[] panes3 = { case_3_0, case_3_1, case_3_2, case_3_3, case_3_4, case_3_5, case_3_6, case_3_7 };
		Pane[] panes4 = { case_4_0, case_4_1, case_4_2, case_4_3, case_4_4, case_4_5, case_4_6, case_4_7 };
		Pane[] panes5 = { case_5_0, case_5_1, case_5_2, case_5_3, case_5_4, case_5_5, case_5_6, case_5_7 };
		Pane[] panes6 = { case_6_0, case_6_1, case_6_2, case_6_3, case_6_4, case_6_5, case_6_6, case_6_7 };
		Pane[] panes7 = { case_7_0, case_7_1, case_7_2, case_7_3, case_7_4, case_7_5, case_7_6, case_7_7 };
		panes[0] = panes0;
		panes[1] = panes1;
		panes[2] = panes2;
		panes[3] = panes3;
		panes[4] = panes4;
		panes[5] = panes5;
		panes[6] = panes6;
		panes[7] = panes7;

		piecesImageView = new HashMap<>();

		partie = new Partie();

		initPiecesImageView();
		initGame();

		firstPaneClicked = null;
		secondPaneClicked = null;

		labelTurn.setText("Blancs");
	}

	private void initPiecesImageView() {

		for (Piece piece : partie.getPlateau().getPiecesNoirs()) {
			piecesImageView.put(piece, new ImageView(piece.getImagePath()));
		}

		for (Piece piece : partie.getPlateau().getPiecesBlanches()) {
			piecesImageView.put(piece, new ImageView(piece.getImagePath()));
		}
	}

	private void initGame() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Case c = partie.getPlateau().getCase(i, j);
				if (c.getPiece() != null) {
					panes[i][j].getChildren().add(piecesImageView.get(c.getPiece()));
				}
			}
		}
	}

	@FXML
	private void clickPane(MouseEvent event) {

		if (firstPaneClicked == null) {
			Pane paneClicked = (Pane) event.getSource();

			int ligne = numeroLigne(paneClicked);
			int colonne = numeroColonne(paneClicked);

			Case caseClicked = partie.getPlateau().getCase(ligne, colonne);

			if (caseClicked.getPiece() != null && caseClicked.getPiece().getColor() == partie.getTour()) {
				// Il y a bien une pièce sur cette case et elle est de la couleur du joueur
				firstPaneClicked = paneClicked;
				setBackground();
			}

		} else if (firstPaneClicked == (Pane) event.getSource()) {

			// La case sélectionnée est relachée
			firstPaneClicked = null;
			setBackground();

		} else if (secondPaneClicked == null) {

			int ligneCase1 = numeroLigne(firstPaneClicked);
			int colonneCase1 = numeroColonne(firstPaneClicked);

			int[][] result = partie.getPlateau().deplacementPossible(ligneCase1, colonneCase1);

			Pane paneClicked = (Pane) event.getSource();
			int ligneCase2 = numeroLigne(paneClicked);
			int colonneCase2 = numeroColonne(paneClicked);

			if (result[ligneCase2][colonneCase2] == 1) {
				// On a cliqué sur une case dont le déplacement était possible

				// On supprime l'image de ce pane
				firstPaneClicked.getChildren().remove(0);
				firstPaneClicked = null;

				secondPaneClicked = paneClicked;

				Case case1 = partie.getPlateau().getCase(ligneCase1, colonneCase1);
				Case case2 = partie.getPlateau().getCase(ligneCase2, colonneCase2);

				// On supprme l'image du pane cliqué dans le cas ou il y avait une pièce adverse
				if (case2.getPiece() != null) {
					secondPaneClicked.getChildren().remove(0);
				}

				// On ajoute la nouvelle image au pane cliqué
				secondPaneClicked.getChildren().add(piecesImageView.get(case1.getPiece()));
				secondPaneClicked = null;

				// On informe le modèle du déplacement
				partie.deplacement(case1, case2);

				labelTurn.setText(partie.getTour() == 0 ? "Blancs" : "Noirs");
				setBackground();
			}
		}
	}

	private void setBackground() {
		for (int i = 0; i < panes.length; i++) {
			for (int j = 0; j < panes.length; j++) {
				if ((i + j) % 2 == 1) {
					panes[i][j].setStyle("-fx-background-color: #DDDDDD;");
				} else {
					panes[i][j].setStyle("-fx-background-color: #FFFFFF;");
				}
			}
		}

		if (firstPaneClicked != null) {
			firstPaneClicked.setStyle("-fx-background-color: #AAAAAA;");
			int ligne = numeroLigne(firstPaneClicked);
			int colonne = numeroColonne(firstPaneClicked);

			int[][] result = partie.getPlateau().deplacementPossible(ligne, colonne);

			if (result != null) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (result[i][j] == 1) {
							panes[i][j].setStyle("-fx-background-color: #FFAE9D;");
						}
					}
				}
			}
		}

	}

	private int numeroLigne(Pane pane) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (panes[i][j].getId().equals(pane.getId()))
					return i;

		return -1;
	}

	private int numeroColonne(Pane pane) {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (panes[i][j].getId().equals(pane.getId()))
					return j;

		return -1;
	}

}
