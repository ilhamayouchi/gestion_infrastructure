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

        String req = "INSERT INTO affectation_equipement (salleid, equipementid, dateaffectation) VALUES (?, ?, ?)";
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
        String req = "DELETE FROM affectation_equipement WHERE salleid = ? AND equipementid = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, o.getSalle().getId());
            ps.setInt(2, o.getEquipement().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(AffectationÉquipement o) {
        String req = "UPDATE affectation_equipement SET dateaffectation = ? WHERE salleid = ? AND equipementid = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setDate(1, new java.sql.Date(o.getDate_affectation().getTime()));
            ps.setInt(2, o.getSalle().getId());
            ps.setInt(3, o.getEquipement().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour : " + ex.getMessage());
            return false;
        }
    }

    @Override
    public AffectationÉquipement findById(int id) {
        return null;  // Pas de méthode findById, car AffectationÉquipement n'a pas d'ID unique
    }

    @Override
    public List<AffectationÉquipement> findAll() {
        List<AffectationÉquipement> affectations = new ArrayList<>();
        String req = "SELECT a.salleid, a.equipementid, a.dateaffectation FROM affectation_equipement a";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int salleId = rs.getInt("salleid");
                int equipementId = rs.getInt("equipementid");
                Date dateAffectation = rs.getDate("dateaffectation");

                Salle salle = salleService.findById(salleId);
                Équipement equipement = equipementService.findById(equipementId);

                if (salle != null && equipement != null) {
                    AffectationÉquipement affectation = new AffectationÉquipement(salle, equipement, dateAffectation);
                    affectations.add(affectation);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des affectations : " + ex.getMessage());
        }

        return affectations;
    }

    // Recherche d'affectation par salle et équipement
    public AffectationÉquipement findBySalleAndEquipement(int salleId, int equipementId) {
        String req = "SELECT a.dateaffectation FROM affectation_equipement a WHERE a.salleid = ? AND a.equipementid = ?";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, salleId);
            ps.setInt(2, equipementId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Salle salle = salleService.findById(salleId);
                Équipement equipement = equipementService.findById(equipementId);

                if (salle != null && equipement != null) {
                    return new AffectationÉquipement(salle, equipement, rs.getDate("dateaffectation"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche d'affectation : " + ex.getMessage());
        }

        System.out.println("Affectation non trouvée.");
        return null;
    }
}
