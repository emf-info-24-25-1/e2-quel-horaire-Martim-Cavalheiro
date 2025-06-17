import models.Horaire;
import models.ModuleInfo;
import models.Professeur;
import services.ServiceFormationMaitres;

public class App {

    public static final String[] NOMS_MODULES = { "G300", "187", "162", "123", "293", "117", "164", "216", "106", "231",
            "122", "431" };

    public static void main(String[] args) {

        Horaire horaire = new Horaire();
        ModuleInfo[] modules1ere = new ModuleInfo[NOMS_MODULES.length]; // ou 12 comme dans la consigne, mais comme ça
                                                                        // c'est plus flexible.

        for (int i = 0; i < modules1ere.length; i++) {
            modules1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }

        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Raboud", "Julien");
        profs[1] = new Professeur("Grillo", "Matias");
        profs[2] = new Professeur("Pereira", "João");
        profs[3] = new Professeur("Zanolari", "Leonardo");
        profs[4] = new Professeur("Fortez", "Daniel");

        do {
            ServiceFormationMaitres.attrivuerModules(profs, modules1ere);
            ServiceFormationMaitres.toutModulesCouverts(profs, modules1ere);

        } while (!ServiceFormationMaitres.toutModulesCouverts(profs, modules1ere));

        System.out.println("L'école a engagé les professeurs suivants");

        for (int i = 0; i < profs.length; i++) {
            System.out.print("- " + profs[i] + " peut enseigner les modules :");

            for (int j = 0; j < profs[i].getModulesEnseignes().length; j++) {
                System.out.print(" " + modules1ere[j].getNom());
            }
            System.out.println();
        }

        System.out.println("\nIl est temps de préparer l'horaire.\n");

        if (horaire.planifier(modules1ere, profs)) { // ou je peut faire une boolean reussi, mais comme ça c'est plus
                                                     // rapide
            System.out.println("Modules planifiés avec succès!");
            horaire.afficherHoraire();

        } else {
            System.out.println("Problème de planification!");
        }

    }

}
