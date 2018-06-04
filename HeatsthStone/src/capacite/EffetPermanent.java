package capacite;

import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;

public class EffetPermanent extends Capacite {
	private int bonusPV, bonusPA;
	
	public EffetPermanent(String nom, String description, int bonusPA, int bonusPV) {
		super(nom, description);
		this.bonusPV = bonusPV;
		this.bonusPA = bonusPA;
	}

	public int getBonusPV() {
		return bonusPV;
	}

	public void setBonusPV(int bonusPV) {
		if(bonusPV < 0)
			throw new IllegalArgumentException("Erreur: Le bonus est négatif.") ;
		this.bonusPV = bonusPV;
	}

	public int getBonusPA() {
		return bonusPA;
	}

	public void setBonusPA(int bonusPA) {
		if(bonusPA < 0)
			throw new IllegalArgumentException("Erreur: Le bonus est négatif.") ;
		this.bonusPA = bonusPA;
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {
		// Il faut appliquer l'effet sur la carte qui entre en jeu
		if(!(cible instanceof Serviteur))
			return;
		Serviteur serviteur = (Serviteur)cible;
		serviteur.setPointsVie(serviteur.getPointsVie() + bonusPV);
		serviteur.setPointsAttaque(serviteur.getPointsAttaque() + bonusPA);


	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetDisparition(Object cible) {
		ICarte carte = (ICarte) cible;
		Serviteur serviteurJeu;
		for (ICarte carteJeu : carte.getProprietaire().getJeu()) {
			serviteurJeu = (Serviteur) carteJeu;
			serviteurJeu.setPointsVie(serviteurJeu.getPointsVie() - bonusPV);
			serviteurJeu.setPointsAttaque(serviteurJeu.getPointsAttaque() - bonusPA);
		}

	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		ICarte carte = (ICarte) cible;
		Serviteur serviteurJeu;
		//IPlateau p = Plateau.getInstance();
		//for (ICarte c : p.getJoueurCourant().getJeu()) {
		for (ICarte carteJeu : carte.getProprietaire().getJeu()) {
			serviteurJeu = (Serviteur) carteJeu;
			serviteurJeu.setPointsVie(serviteurJeu.getPointsVie() + bonusPV);
			serviteurJeu.setPointsAttaque(serviteurJeu.getPointsAttaque() + bonusPA);
		}

	}

}
