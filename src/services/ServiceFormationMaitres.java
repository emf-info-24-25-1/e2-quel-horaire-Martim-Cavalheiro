package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {

    public static void attrivuerModules(Professeur[] professeurs, ModuleInfo[] modules) {

        for (int i = 0; i < professeurs.length; i++) {
            int nbre = (int) (Math.random() * ((modules.length -1) - 0 + 1)) + 0;

            if (professeurs[i].enseigneCeModule(modules[nbre].getNom())) {
                do {
                    nbre = (int) (Math.random() * ((modules.length -1) - 0 + 1)) + 0;
                } while (!professeurs[i].enseigneCeModule(modules[nbre].getNom()));

            } else {
                professeurs[i].ajouterModuleEnseigne(modules[nbre]);
            }
        }
    }

    public static boolean toutModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean profEnseigneModule = true;

        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                if (!profs[j].enseigneCeModule(modules[i].getNom())) {
                    profEnseigneModule = false;
                    break;
                }
            }

        }

        return profEnseigneModule;
    }
}
