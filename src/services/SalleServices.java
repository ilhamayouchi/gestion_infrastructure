/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Salle;
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
public class SalleServices implements Idao<Salle> {

    private Connexion connexion;

    public SalleServices() {
        connexion = Connexion.getInstance();
        
    }

    @Override
    public boolean create(Salle o) {
        String req = "insert into Salle (nom, type, capacite) values (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setInt(3, o.getCapacite());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création de la salle : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Salle o) {
        String req = "delete from Salle where id = ?";
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
    public boolean update(Salle o) {
        String req = "update Salle set nom = ?, type = ?, capacite = ? where id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setInt(3, o.getCapacite());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Salle findById(int id) {
        String req = " select * from Salle where id = ? ";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Salle(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getInt("capacite"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Salle> findAll() {
        List<Salle> salles = new ArrayList<>();
        String req = "select * from Salle";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salles.add(new Salle(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getInt("capacite")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return salles;
    }
}
