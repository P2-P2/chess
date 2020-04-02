package peter.echec.model;

public class Partie {

	private Plateau plateau;

	// tour = 1 au blanc, tour = 0 au noir
	private int tour;

	public Partie() {

		plateau = new Plateau();

		// Les blancs commencent la partie
		tour = 0;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void deplacement(Case caseSelectionnee, Case nouvelleCase) {

		plateau.deplacement(caseSelectionnee, nouvelleCase);
		
		tour = tour == 0 ? 1 : 0;
	}
	
	public int getTour() {
		return tour;
	}
}
