/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Équipement;
import connexion.Connexion;
import dao.Idao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class EquipementServices implements Idao<Équipement> {

    private Connexion connexion;

    public EquipementServices() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Équipement o) {
        String req = "insert into Équipement (nom, type, etat) values (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setString(3, o.getEtat());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création de l'équipement : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Équipement o) {
        String req = "delete from Équipement where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Équipement o) {
        String req = "update Équipement set nom = ?, type = ?, etat = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setString(3, o.getEtat());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Équipement findById(int id) {
        String req = "select * from Équipement where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Équipement(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getString("etat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Équipement> findAll() {
        List<Équipement> equipements = new ArrayList<>();
        String req = "select * from Équipement";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                equipements.add(new Équipement(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getString("etat")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return equipements;
    }
}
