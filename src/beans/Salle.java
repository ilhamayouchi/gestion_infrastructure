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
public class Salle {
    private int id;
    private String nom;
    private String type;
    private int capacite;
    public Salle(int id, String nom, String type, int capacite) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.capacite = capacite;
    }
    public Salle(String nom, String type, int capacite) {
        this.nom = nom;
        this.type = type;
        this.capacite = capacite ;
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}

