/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogramme;

import beans.Salle;
import beans.Équipement;
import beans.AffectationÉquipement;
import java.util.Date;
import java.util.List;
import services.EquipementServices;
import services.SalleServices;
import services.AffectationService;

/**
 *
 * @author hp
 */
public class Testpro {

    public static void main(String[] args) {
        testSalleService();
        testÉquipementService();
        testAffectationÉquipementService();
    }

    // Test pour SalleService
    public static void testSalleService() {
        SalleServices salleService = new SalleServices();

        System.out.println("Test de création de salles...");
        salleService.create(new Salle("Salle A", "Amphi", 100));
        salleService.create(new Salle("Salle B", "Salle de réunion", 50));
        System.out.println("Salles créées avec succès");

        System.out.println("Liste des salles :");
        List<Salle> salles = salleService.findAll();
        for (Salle salle : salles) {
            System.out.println(salle.getNom() + " - " + salle.getType() + " - " + salle.getCapacite() + "-" + salle.getId());
        }

        System.out.println("Test de recherche d'une salle par id");
        Salle salleTrouvee = salleService.findById(1);
        if (salleTrouvee != null) {
            System.out.println("Salle trouvée : " + salleTrouvee.getNom());
        } else {
            System.out.println("Salle non trouvée.");
        }

        System.out.println("Test de mise à jour d'une salle");
        if (salleTrouvee != null) {
            salleTrouvee.setCapacite(70);
            salleService.update(salleTrouvee);
            System.out.println("Salle mise à jour avec succès");
        } else {
            System.out.println("Impossible de mettre à jour la salle.");
        }

        System.out.println("Test de suppression d'une salle");
        if (salleTrouvee != null) {
            salleService.delete(salleTrouvee);
            System.out.println("Salle supprimée avec succès");
        } else {
            System.out.println("Impossible de supprimer la salle.");
        }

    }

    // Test pour EquipementService
    public static void testÉquipementService() {
        EquipementServices equipementService = new EquipementServices();

        System.out.println("Création d'équipements ");
        equipementService.create(new Équipement("projecteur", "Audio Visuel", "Fonctionnel"));
        equipementService.create(new Équipement("ordinateur", "Informatique", "En panne"));
        System.out.println("Équipements créés avec succès");

        System.out.println(" Afficher équipements ");
        List<Équipement> equipements = equipementService.findAll();
        for (Équipement equipement : equipements) {
            System.out.println(equipement.getNom() + " - " + equipement.getType() + " - " + equipement.getEtat());
        }

        System.out.println("Rechrche d'id ");
        Équipement equipementTrouve = equipementService.findById(1);
        if (equipementTrouve != null) {
            System.out.println("équipement trouvé : " + equipementTrouve.getNom());
        } else {
            System.out.println("Équipement non trouvé.");
        }

        System.out.println(" Mise a jour ");
        if (equipementTrouve != null) {
            equipementTrouve.setEtat("  ");
            equipementService.update(equipementTrouve);
            System.out.println(" Équipement mis à jour avec succès");
        } else {
            System.out.println(" Impossible de mettre à jour l'équipement.");
        }

        System.out.println(" suppression ");
        if (equipementTrouve != null) {
            equipementService.delete(equipementTrouve);
            System.out.println("Équipement supprimé avec succès");
        } else {
            System.out.println("Impossible de supprimer équipement");
        }

    }

    //Test AffectationEquipement
    public static void testAffectationÉquipementService() {
        SalleServices salleService = new SalleServices();
        EquipementServices equipementService = new EquipementServices();
        AffectationService affectationService = new AffectationService();

        
        Salle salle1 = new Salle(4,"Salle A", "Amphi", 100);
        Salle salle2 = new Salle(5,"Salle B", "Salle de réunion", 50);
        salleService.create(salle1);
        salleService.create(salle2);

        Équipement equipement1 = new Équipement(4,"Projecteur", "Audio Visuel", "Fonctionnel");
        Équipement equipement2 = new Équipement(5,"Ordinateur", "Informatique", "En panne");
        equipementService.create(equipement1);
        equipementService.create(equipement2);

        System.out.println("Affectation des équipements aux salles..");
        AffectationÉquipement affectation1 = new AffectationÉquipement(salle1, equipement1, new Date());
        AffectationÉquipement affectation2 = new AffectationÉquipement(salle2, equipement2, new Date());
        affectationService.create(affectation1);
        affectationService.create(affectation2);

        System.out.println("Liste des affectations :");
        List<AffectationÉquipement> affectations = affectationService.findAll();
        for (AffectationÉquipement affectation : affectations) {
            System.out.println("Salle: " + affectation.getSalle().getNom()
                    + " - Équipement: " + affectation.getEquipement().getNom()
                    + " - Date: " + affectation.getDate_affectation());
        }

        System.out.println("Recherche d'une affectation..");
        AffectationÉquipement affectationTrouvee = affectationService.findById(1);
        if (affectationTrouvee != null) {
            System.out.println("Affectation trouvée : Salle - "
                    + affectationTrouvee.getSalle().getNom()
                    + " avec Équipement - "
                    + affectationTrouvee.getEquipement().getNom());
        } else {
            System.out.println("Affectation non trouvée.");
        }

        System.out.println("Mise à jour d'une affectation..");
        if (affectationTrouvee != null) {
            affectationTrouvee.setDate_affectation(new Date());
            affectationService.update(affectationTrouvee);
            System.out.println("Affectation mise à jour avec succès.");
        } else {
            System.out.println("Impossible de mettre à jour l'affectation.");
        }

        System.out.println("Suppression d'une affectation..");
        if (affectationTrouvee != null) {
            affectationService.delete(affectationTrouvee);
            System.out.println("Affectation supprimée avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'affectation.");
        }
    }

}
