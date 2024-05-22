package com.example.springhibernate.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
public class Cv {
    @Id
    @GeneratedValue
    private Long id;
    private String profile;
    @OneToOne
    private InformationPerso information;
    @ManyToMany
    private List<Competance> skillsList;
    @ManyToMany
    private List<Entreprise> companiesList;

    public Cv(String profile) {
        this.profile = profile;
    }

    public Cv() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public InformationPerso getInformation() {
        return information;
    }

    public void setInformation(InformationPerso information) {
        this.information = information;
    }

    public List<Competance> getCompetance() {
        return skillsList;
    }

    public void setSkillsList(List<Competance> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Entreprise> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<Entreprise> companiesList) {
        this.companiesList = companiesList;
    }


}
