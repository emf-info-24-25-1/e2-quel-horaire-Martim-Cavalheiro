package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {

    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;

    //MR Les deux attibuts ci-dessous doivent être final
    private String nom;
    private ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];

        for (int i = 0; i < 4; i++) {
            modules[i] = new ModuleInfo("Matu");
        }
    }

    public boolean planifierModule(ModuleInfo module) {
        boolean moduleDisponible = false;

        int journeeDisponible = 0;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                journeeDisponible++;
                if (journeeDisponible == 3) {
                    moduleDisponible = true;
                    break;
                }
            }
        }
        if (moduleDisponible) {
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] == null) {
                    modules[i] = module;
                }
            }
        }

        return moduleDisponible;
    }

    public void afficherHoraire() {
        int jour = 0;

        //MR On aurait pu faire un saut de deux pour passer de 0 à 2 à 4 à 6 et 8
        for (int i = 0; i < modules.length; i++) {

            System.out.println(DayOfWeek.values()[jour++].getDisplayName(TextStyle.FULL, Locale.FRANCE));

            //MR Le matin est i
            System.out.println("    matin      : " + modules[i++].toString());
            //MR l'après-midi est i+1 et pas i++ car sinon on modifie le i
            System.out.println("    après-midi : " + modules[i].toString());

        }

    }

    public boolean estTotalementPlanifie() {
        boolean blocPlanifier = true;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                blocPlanifier = false;
                break;
            }
        }

        return blocPlanifier;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean moduleDansBloc = false;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == module) {
                moduleDansBloc = true;
                break;
            }
        }

        return moduleDansBloc;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
