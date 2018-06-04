package heros;

import capacite.ICapacite;

public abstract class Heros {
	private String nom;
	private int pointsVie = 15;
	private ICapacite pouvoir;
	private boolean attaquable = true;
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public void setPointsVie(int pointsVie) {
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
	
	
	
}
