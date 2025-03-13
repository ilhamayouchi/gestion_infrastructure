package services;

import beans.AffectationÉquipement;
import beans.Salle;
import beans.Équipement;
import connexion.Connexion;
import dao.Idao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AffectationService implements Idao<AffectationÉquipement> {

    private Connexion connexion;
    private SalleServices salleService;
    private EquipementServices equipementService;

    public AffectationService() {
        connexion = Connexion.getInstance();
        salleService = new SalleServices();
        equipementService = new EquipementServices();
    }

    @Override
    public boolean create(AffectationÉquipement o) {
        if (o.getSalle() == null || o.getEquipement() == null) {
            System.out.println("Erreur : La salle ou l'équipement est null");
            return false;
        }

        if (o.getSalle().getId() <= 0) {
            System.out.println("Erreur : L'ID de la salle est invalide (ID: " + o.getSalle().getId() + ")");
            return false;
        }

        if (o.getEquipement().getId() <= 0) {
            System.out.println("Erreur : L'ID de l'équipement est invalide (ID: " + o.getEquipement().getId() + ")");
            return false;
        }

        Salle salle = salleService.findById(o.getSalle().getId());
        if (salle == null) {
            System.out.println("Erreur : La salle avec l'ID " + o.getSalle().getId() + " n'existe pas.");
            return false;
        }

        Équipement equipement = equipementService.findById(o.getEquipement().getId());
        if (equipement == null) {
            System.out.println("Erreur : L'équipement avec l'ID " + o.getEquipement().getId() + " n'existe pas.");
            return false;
        }

        String req = "INSERT INTO affectation_equipement (salle, equipement, dateaffectation) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, o.getSalle().getId());
            ps.setInt(2, o.getEquipement().getId());
            ps.setDate(3, new java.sql.Date(o.getDate_affectation().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'affectation de l'équipement : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(AffectationÉquipement o) {
        if (o.getSalle() == null || o.getEquipement() == null) {
            System.out.println("Erreur : La salle ou l'équipement est null");
            return false;
        }

        if (o.getSalle().getId() <= 0) {
            System.out.println("Erreur : L'ID de la salle est invalide (ID: " + o.getSalle().getId() + ")");
            return false;
        }

        if (o.getEquipement().getId() <= 0) {
            System.out.println("Erreur : L'ID de l'équipement est invalide (ID: " + o.getEquipement().getId() + ")");
            return false;
        }

        String req = "DELETE FROM affectation_equipement WHERE salle = ? AND equipement= ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, o.getSalle().getId());
            ps.setInt(2, o.getEquipement().getId());
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'affectation : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(AffectationÉquipement o) {
        if (o.getSalle() == null || o.getEquipement() == null) {
            System.out.println("Erreur : La salle ou l'équipement est null");
            return false;
        }

        if (o.getSalle().getId() <= 0) {
            System.out.println("Erreur : L'ID de la salle est invalide (ID: " + o.getSalle().getId() + ")");
            return false;
        }

        if (o.getEquipement().getId() <= 0) {
            System.out.println("Erreur : L'ID de l'équipement est invalide (ID: " + o.getEquipement().getId() + ")");
            return false;
        }

        String req = "UPDATE affectation_equipement SET dateaffectation = ? WHERE salle = ? AND equipement = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setDate(1, new java.sql.Date(o.getDate_affectation().getTime()));
            ps.setInt(2, o.getSalle().getId());
            ps.setInt(3, o.getEquipement().getId());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'affectation : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public AffectationÉquipement findById(int id) {
        return null;
    }

    @Override
    public List<AffectationÉquipement> findAll() {
        List<AffectationÉquipement> affectations = new ArrayList<>();
        String req = "SELECT a.salle, a.equipement, a.dateaffectation FROM affectation_equipement a";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int salleId = rs.getInt("salle");
                int equipementId = rs.getInt("equipement");
                Date dateAffectation = rs.getDate("dateaffectation");

                Salle salle = salleService.findById(salleId);
                Équipement equipement = equipementService.findById(equipementId);

                if (salle != null && equipement != null) {
                    AffectationÉquipement affectation = new AffectationÉquipement(salle, equipement, dateAffectation);
                    affectations.add(affectation);
                } else {
                    System.out.println("Avertissement : Salle ou équipement non trouvé pour l'affectation (Salle ID: " + salleId + ", Équipement ID: " + equipementId + ")");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des affectations : " + ex.getMessage());
        }

        return affectations;
    }

    public AffectationÉquipement findBySalleAndEquipement(int salleId, int equipementId) {
        if (salleId <= 0 || equipementId <= 0) {
            System.out.println("Erreur : IDs invalides (Salle ID: " + salleId + ", Équipement ID: " + equipementId + ")");
            return null;
        }

        String req = "SELECT a.dateaffectation FROM affectation_equipement a WHERE a.salle = ? AND a.equipement = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, salleId);
            ps.setInt(2, equipementId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Récupérer la salle et l'équipement
                    Salle salle = salleService.findById(salleId);
                    Équipement equipement = equipementService.findById(equipementId);

                    if (salle != null && equipement != null) {
                        return new AffectationÉquipement(salle, equipement, rs.getDate("dateaffectation"));
                    } else {
                        System.out.println("Erreur : Salle ou équipement non trouvé.");
                        return null;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche d'affectation : " + ex.getMessage());
        }

        System.out.println("Affectation non trouvée.");
        return null;
    }
}
