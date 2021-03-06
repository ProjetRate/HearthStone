package carte;

import capacite.ICapacite;
import capacites.AttaqueCiblee;
import exception.HearthStoneException;

import java.util.ArrayList;

public abstract class Serviteur extends Carte {
    private int pointsAttaque;
    private int pointsVie;
    private boolean attaquable = true, peutAttaquer = false;

    public Serviteur(int cout, String nom, ArrayList<ICapacite> capacite, int pointsAttaque, int pointsVie) throws HearthStoneException {
        super(cout, nom, capacite);
        if(capacite == null)
        	throw new IllegalArgumentException("Erreur: La liste de capacitÚs du serviteur est null.");
        super.getCapacites().add(new AttaqueCiblee(pointsAttaque));
        setPointsAttaque(pointsAttaque);
        this.pointsVie = pointsVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public int getPointsVie() {
        return pointsVie;
    }
    
    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
        if(disparait())
        	getProprietaire().perdreCarte(this);
    }

    public void setPointsAttaque(int pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
        for (ICapacite capacite : super.getCapacites()) {
			if(capacite instanceof AttaqueCiblee)
				((AttaqueCiblee) capacite).setDegats(pointsAttaque);
		}
    }

	public boolean estAttaquable() {
		return attaquable;
	}

	public void setAttaquable(boolean attaquable) {
		this.attaquable = attaquable;
	}

	public void setPeutAttaquer(boolean peutAttaquer) {
		this.peutAttaquer = peutAttaquer;
		
	}
	
	public boolean PeutAttaquer() {
		return peutAttaquer;
	}
	
	@Override
    public boolean disparait() {
		if (pointsVie <= 0)
			return true;
        return false;
    }
	
	@Override
	public String toString() {
		//return "Carte [cout=" + cout + ", nom=" + nom + ", capacite=" + capacites + "]";
		return "[" + super.getCout() +" "+ super.getNom() +" "+ pointsAttaque+"/"+pointsVie+ "]"; 
	}
}
