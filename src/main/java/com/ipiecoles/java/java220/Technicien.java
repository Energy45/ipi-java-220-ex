package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien> {

    private Integer grade;

    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public void setSalaire(Double salaire) {
        salaire *= (((this.grade) * 10d ) +100d ) / 100d;
        super.setSalaire(salaire);
    }

    public Double getPrimeAnnuelle() {
        Double nouvellePrime = 0.0;
        //On ajoute la prime annuelle de base en fonction du grade
        nouvellePrime += Entreprise.primeAnnuelleBase() * ((((this.grade) * 10d ) +100d ) / 100d);
        //On ajoute la prime d'anciennete en fonction du nombre d'années d'anciennete
        nouvellePrime += Entreprise.PRIME_ANCIENNETE * super.getNombreAnneeAnciennete();
        return nouvellePrime;
    }

    public Integer getNbConges() {
        return super.getNbConges() + getNombreAnneeAnciennete();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int compareTo(Technicien technicien) {
        return this.getGrade() - technicien.getGrade();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }
}
