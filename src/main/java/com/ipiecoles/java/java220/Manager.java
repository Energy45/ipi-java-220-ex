package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Employe {

    private HashSet<Technicien> equipe = new HashSet<>();

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + Entreprise.PRIME_MANAGER_PAR_TECHNICIEN * this.equipe.size();
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void ajoutTechnicienEquipe(Technicien technicienAjout) {
        this.equipe.add(technicienAjout);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        this.equipe.add(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }

    public void setSalaire(Double salaire) {
        Double newSalaire = salaire * Entreprise.INDICE_MANAGER + ((salaire * 0.1) * equipe.size());
        super.setSalaire(newSalaire);
    }

    private void augmenterSalaireEquipe(Double percentage) {
        for(Technicien technicien : this.equipe) {
            technicien.augmenterSalaire(percentage);
        }
    }

    public void augmenterSalaire(Double percentage) {
        augmenterSalaireEquipe(percentage);
        super.augmenterSalaire(percentage);
    }

    public List<Technicien> equipeParGrade() {
        return equipe.stream()
                .sorted(Technicien::compareTo).collect(Collectors.toList());
    }

    public Double salaireEquipeGrade1() {
        return equipe.stream()
                .filter(technicien -> technicien.getGrade().equals(1))
                .mapToDouble(Technicien::getSalaire)
                .sum();
    }
}
