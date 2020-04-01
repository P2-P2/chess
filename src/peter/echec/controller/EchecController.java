package peter.echec.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import peter.echec.model.Case;
import peter.echec.model.Plateau;

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

	private Plateau plateau;

	private Pane firstPaneClicked;
	private Pane secondPaneClicked;

	private int whiteTurn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		plateau = new Plateau();
		panes = new Pane[8][8];
		panes[0][0] = case_0_0;
		panes[0][1] = case_0_1;
		panes[0][2] = case_0_2;
		panes[0][3] = case_0_3;
		panes[0][4] = case_0_4;
		panes[0][5] = case_0_5;
		panes[0][6] = case_0_6;
		panes[0][7] = case_0_7;
		panes[1][0] = case_1_0;
		panes[1][1] = case_1_1;
		panes[1][2] = case_1_2;
		panes[1][3] = case_1_3;
		panes[1][4] = case_1_4;
		panes[1][5] = case_1_5;
		panes[1][6] = case_1_6;
		panes[1][7] = case_1_7;
		panes[2][0] = case_2_0;
		panes[2][1] = case_2_1;
		panes[2][2] = case_2_2;
		panes[2][3] = case_2_3;
		panes[2][4] = case_2_4;
		panes[2][5] = case_2_5;
		panes[2][6] = case_2_6;
		panes[2][7] = case_2_7;
		panes[3][0] = case_3_0;
		panes[3][1] = case_3_1;
		panes[3][2] = case_3_2;
		panes[3][3] = case_3_3;
		panes[3][4] = case_3_4;
		panes[3][5] = case_3_5;
		panes[3][6] = case_3_6;
		panes[3][7] = case_3_7;
		panes[4][0] = case_4_0;
		panes[4][1] = case_4_1;
		panes[4][2] = case_4_2;
		panes[4][3] = case_4_3;
		panes[4][4] = case_4_4;
		panes[4][5] = case_4_5;
		panes[4][6] = case_4_6;
		panes[4][7] = case_4_7;
		panes[5][0] = case_5_0;
		panes[5][1] = case_5_1;
		panes[5][2] = case_5_2;
		panes[5][3] = case_5_3;
		panes[5][4] = case_5_4;
		panes[5][5] = case_5_5;
		panes[5][6] = case_5_6;
		panes[5][7] = case_5_7;
		panes[6][0] = case_6_0;
		panes[6][1] = case_6_1;
		panes[6][2] = case_6_2;
		panes[6][3] = case_6_3;
		panes[6][4] = case_6_4;
		panes[6][5] = case_6_5;
		panes[6][6] = case_6_6;
		panes[6][7] = case_6_7;
		panes[7][0] = case_7_0;
		panes[7][1] = case_7_1;
		panes[7][2] = case_7_2;
		panes[7][3] = case_7_3;
		panes[7][4] = case_7_4;
		panes[7][5] = case_7_5;
		panes[7][6] = case_7_6;
		panes[7][7] = case_7_7;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				Case c = plateau.getCase(i, j);
				if (c.getPiece() != null) {
					panes[i][j].getChildren().add(new ImageView(c.getPiece().getImage()));
				}
			}
		}

		firstPaneClicked = null;
		secondPaneClicked = null;

		whiteTurn = 1;
		labelTurn.setText("Blancs");
	}

	@FXML
	private void clickPane(MouseEvent event) {

		if (firstPaneClicked == null) {
			firstPaneClicked = (Pane) event.getSource();

			int row = numeroLigne(firstPaneClicked);
			int column = numeroColonne(firstPaneClicked);

			Case c = plateau.getCase(row, column);

			if (c.getPiece() == null) {
				firstPaneClicked = null;
			} else if (c.getPiece().getColor() == whiteTurn) {
				firstPaneClicked = null;
			}

			setBackground(firstPaneClicked);
			
		} else if (firstPaneClicked == (Pane) event.getSource()) {

			firstPaneClicked = null;
			setBackground(firstPaneClicked);

		} else if (secondPaneClicked == null) {

			int rowCase1 = numeroLigne(firstPaneClicked);
			int columnCase1 = numeroColonne(firstPaneClicked);

			Case case1 = plateau.getCase(rowCase1, columnCase1);
			int[][] result = case1.getPiece().deplacement(plateau.getPlateau(), rowCase1, columnCase1);

			Pane paneClicked = (Pane) event.getSource();
			int rowCase2 = numeroLigne(paneClicked);
			int columnCase2 = numeroColonne(paneClicked);

			if (result[rowCase2][columnCase2] == 1) {

				firstPaneClicked.getChildren().remove(0);
				firstPaneClicked = null;

				secondPaneClicked = paneClicked;
				System.out.println("-----> " + secondPaneClicked.getId());

				Case case2 = plateau.getCase(rowCase2, columnCase2);

				if (case2.getPiece() != null) {
					secondPaneClicked.getChildren().remove(0);
				}

				secondPaneClicked.getChildren().add(new ImageView(case1.getPiece().getImage()));
				secondPaneClicked = null;

				case2.setPiece(case1.getPiece());
				case1.setPiece(null);

				whiteTurn = whiteTurn == 0 ? 1 : 0;

				labelTurn.setText(whiteTurn == 1 ? "Blancs" : "Noirs");
				setBackground(firstPaneClicked);

			}

		} 
	}

	private void setBackground(Pane paneClicked) {
		for (int i = 0; i < panes.length; i++) {
			for (int j = 0; j < panes.length; j++) {
				if ((i + j) % 2 == 1) {
					panes[i][j].setStyle("-fx-background-color: #DDDDDD;");
				} else {
					panes[i][j].setStyle("-fx-background-color: #FFFFFF;");
				}
			}
		}

		if (paneClicked != null) {
			firstPaneClicked.setStyle("-fx-background-color: #AAAAAA;");
			int row = numeroLigne(firstPaneClicked);
			int column = numeroColonne(firstPaneClicked);

			Case c = plateau.getCase(row, column);
			int[][] result = c.getPiece().deplacement(plateau.getPlateau(), row, column);

			if (result != null) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						System.out.print(" " + result[i][j]);
						if (result[i][j] == 1) {
							panes[i][j].setStyle("-fx-background-color: #FFAE9D;");
						}
					}
					System.out.println();
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
