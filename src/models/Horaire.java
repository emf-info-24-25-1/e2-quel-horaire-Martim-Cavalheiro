package models;

public class Horaire {

    public static final int NBRE_DE_BLOCS = 6;
    //MR peut-être mis en final
    private Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOCS];

        int semestre = 1;
        for (int i = 0; i < blocs.length; i++) {
            if (i == 3) {
                semestre++;
            }
            blocs[i] = new Bloc("B" + (i + 1) + "S" + semestre);
        }
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean profPeutEnseigner = false;
        boolean peutPlanifier = false;
        boolean retour = false;

        for (int i = 0; i < modules.length; i++) {

            for (int j = 0; j < profs.length; j++) {

                if (profs[j].enseigneCeModule(modules[i].getNom())) { // Ici on deverai donné le Prof au module.
                    //MR Ici il faut plutôt dire au module que le prof va faire ce module
                    profs[j].ajouterModuleEnseigne(modules[i]);
                    profPeutEnseigner = true;
                    break;
                }

            }
        }

        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(null)) {
                blocs[i].planifierModule(modules[i]);
                peutPlanifier = true;
            }
        }

        if (profPeutEnseigner) {
            if (peutPlanifier) {
                retour = true;
            }
        }

        return retour;
    }

    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            System.out.println(blocs[i].getNom());
            System.out.println("--------------");
            blocs[i].afficherHoraire();
        }
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {

        //MR le retour par défaut n'est pas un bloc null, mais null
        Bloc retour = new Bloc(null);

        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(module)) {
                retour = blocs[i];
                break;
            }
        }

        return retour;
    }

}
