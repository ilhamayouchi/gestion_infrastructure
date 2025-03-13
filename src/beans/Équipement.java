/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author hp
 */
public class Équipement {

    private int id;
    private String nom;
    private String type;
    private String etat;

    public Équipement(int id, String nom, String type, String etat) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.etat = etat;
    }

    public Équipement(String nom, String type, String etat) {
        this.nom = nom;
        this.type = type;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
