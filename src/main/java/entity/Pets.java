/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Pets {

    private int idPets;
    private String name;
    private String specie;
    private String breed;
    private LocalDate dateOfBirth;
    private String ownerName;
    private String treatment;
    private String vaccineName;
    private LocalDate dateVaccineApplied;

    public Pets(int idPets, String name, String specie, String breed, LocalDate dateOfBirth, String ownerName, String treatment, String vaccineName, LocalDate dateVaccineApplied) {
        this.idPets = idPets;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
        this.treatment = treatment;
        this.vaccineName = vaccineName;
        this.dateVaccineApplied = dateVaccineApplied;
    }

    public Pets(String name, String specie, String breed, LocalDate dateOfBirth, String ownerName, String treatment, String vaccineName, LocalDate dateVaccineApplied) {
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
        this.treatment = treatment;
        this.vaccineName = vaccineName;
        this.dateVaccineApplied = dateVaccineApplied;
    }

    public int getIdPets() {
        return idPets;
    }

    public String getName() {
        return name;
    }

    public String getSpecie() {
        return specie;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public LocalDate getDateVaccineApplied() {
        return dateVaccineApplied;
    }

    public void setIdPets(int idPets) {
        this.idPets = idPets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public void setDateVaccineApplied(LocalDate dateVaccineApplied) {
        this.dateVaccineApplied = dateVaccineApplied;
    }

    @Override
    public String toString() {
        return "Pets{" + ", name=" + name + ", specie=" + specie + ", breed=" + breed + ", dateOfBirth=" + dateOfBirth + ", ownerName=" + ownerName + ", treatment=" + treatment + ", vaccineName=" + vaccineName + ", dateVaccineApplied=" + dateVaccineApplied + '}';
    }

}
