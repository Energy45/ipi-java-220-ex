package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {
    private Double caAnnuel = null;
    private Integer performance;

    public Commercial() {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }

    public Note equivalenceNote() {

        switch(performance) {
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return null;
        }
    }

    public boolean performanceEgale(Integer performance) {
        if(this.performance.equals(performance)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) &&
                Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Double getPrimeAnnuelle() {
        if(this.caAnnuel == null) {
            return 500D;
        } else {
            Double primeAnnuelle = Math.ceil(caAnnuel * 0.05);
            if(primeAnnuelle < 500) {
                return 500D;
            }
            return primeAnnuelle;
        }
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getPerformance() {
        return performance;
    }
}
