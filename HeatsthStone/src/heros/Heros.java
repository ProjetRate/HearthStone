package heros;

import capacite.ICapacite;
import exception.HearthStoneException;
import joueur.IJoueur;

public abstract class Heros {
	private String nom;
	private int pointsVie = 15;
	private ICapacite pouvoir;
	private IJoueur proprietaire = null;
	private boolean attaquable = true, peutAttaquer = true;
	/*
	public Heros(Heros heros) {
        this.nom = new String(heros.nom);
        this.pouvoir = heros.getPouvoir();
    }*/
	
	public Heros(String nom, ICapacite capacite) {
        this.nom = nom;
        this.pouvoir = capacite;
    }

	public String getNom() {
		return nom;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public void setPointsVie(int pointsVie) throws HearthStoneException {
		this.pointsVie = pointsVie;
	}

	public ICapacite getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(ICapacite pouvoir) {
		this.pouvoir = pouvoir;
	}

	public boolean estAttaquable() {
		return attaquable;
	}

	public void setAttaquable(boolean attaquable) {
		this.attaquable = attaquable;
	}

	@Override
	public String toString() {
		//return "Heros [nom=" + nom + ", pointsVie=" + pointsVie + ", pouvoir=" + pouvoir + "]";
		return "" + nom + " " + pointsVie;
	}

	public boolean meurt() {
		if(pointsVie <=0)
			return true;
		return false;
	}

	public IJoueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(IJoueur joueur) {
		if(joueur == null)
			throw new IllegalArgumentException("Erreur: Le joueur ne doit pas être null.");
		this.proprietaire = joueur;
		
	}

	public boolean peutAttaquer() {
		return peutAttaquer;
	}

	public void setPeutAttaquer(boolean peutAttaquer) {
		this.peutAttaquer = peutAttaquer;
	}
	
	
	
}
