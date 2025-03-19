/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author hp
 */
public class AffectationÉquipement {
    // Attributs

    private Salle salle;
    private Équipement equipement;
    private Date dateAffectation;

    // Constructeur
    public AffectationÉquipement(Salle salle, Équipement equipement, Date dateaffectation) {
        this.salle = salle;
        this.equipement = equipement;
        this.dateAffectation = dateaffectation;
    }

    // Getters et Setters
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Équipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Équipement equipement) {
        this.equipement = equipement;
    }

    public Date getDate_affectation() {
        return dateAffectation;
    }

    public void setDate_affectation(Date dateaffectation) {
        this.dateAffectation = dateaffectation;
    }
}
