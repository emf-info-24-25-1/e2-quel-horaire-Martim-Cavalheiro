package models;

public class Professeur {
    //MR Manque les finals sur les deux premiers attributs
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean profEnseigneModule = false;

        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i].getNom() == nomDuModule) {
                profEnseigneModule = true;
                break;
            }
        }
        return profEnseigneModule;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {

        ModuleInfo[] ajoutModule = new ModuleInfo[modulesEnseignes.length + 1];

        int j = 0;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            ajoutModule[j++] = modulesEnseignes[i];
        }

        //MR Attention le j++ se fait après donc il ne sera pas sur la bonne cellule du tableau
        ajoutModule[j++] = module;

        modulesEnseignes = ajoutModule;
    }

    public void viderModules() {

        ModuleInfo[] videModule = new ModuleInfo[0];

        //MR Ce for n'est pas nécessaire car on ne réutilise plus moduleEnseignes
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = null;
        }

        modulesEnseignes = videModule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }
}
