/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogramme;
import beans.Salle;
import beans.Équipement;
import services.SalleServices;
import services.EquipementServices;
import java.util.List;

/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args) {
        testSalleService();
        testÉquipementService();
    }

    // Test pour SalleService
    public static void testSalleService() {
        SalleServices salleService = new SalleServices();

        
        System.out.println("Test de création de salles...");
        salleService.create(new Salle("Salle A", "Amphi", 100));
        salleService.create(new Salle("Salle B", "Salle de réunion", 50));
        System.out.println("Salles créées avec succès !");

        
        System.out.println("Liste des salles :");
        List<Salle> salles = salleService.findAll();
        for (Salle salle : salles) {
            System.out.println(salle.getNom() + " - " + salle.getType() + " - " + salle.getCapacite());
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
            salleTrouvee.setCapacite(120);
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
        equipementService.create(new Équipement("Projecteur", "Audio-Visuel", "Fonctionnel"));
        equipementService.create(new Équipement("Ordinateur", "Informatique", "En panne"));
        System.out.println("Équipements créés avec succès");

        
        System.out.println(" Afficher équipements ");
        List<Équipement> equipements = equipementService.findAll();
        for (Équipement equipement : equipements) {
            System.out.println(equipement.getNom() + " - " + equipement.getType() + " - " + equipement.getEtat());
        }

        
        System.out.println("Rechrche d'id ");
        Équipement equipementTrouve = equipementService.findById(1);
        if (equipementTrouve != null) {
            System.out.println("Équipement trouvé : " + equipementTrouve.getNom());
        } else {
            System.out.println("Équipement non trouvé.");
        }

        System.out.println(" Mise a jour ");
        if (equipementTrouve != null) {
            equipementTrouve.setEtat("  ");
            equipementService.update(equipementTrouve);
            System.out.println(" Équipement mis à jour avec succès !");
        } else {
            System.out.println(" Impossible de mettre à jour l'équipement.");
        }

        
        System.out.println(" Suppression ");
        if (equipementTrouve != null) {
            equipementService.delete(equipementTrouve);
            System.out.println("Équipement supprimé avec succès");
        } else {
            System.out.println("Impossible de supprimer équipement");
        }

        
    }
}




