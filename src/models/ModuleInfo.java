package models;

public class ModuleInfo {

    private String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        this.professeur = null;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        String retour;

        if (professeur != null) {
            retour = nom + " avec " + professeur.getPrenom() + " " + professeur.getPrenom();
        } else {
            retour = nom;
        }

        return retour;
    }
}
