package com.example.springhibernate.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cv {
    @Id
    @GeneratedValue
    private Long id;
    private String profile;
    @OneToOne(orphanRemoval = true)
    private InformationPerso information;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Competance> competanceList;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Entreprise> entrepriseList;

    public Cv(String profile) {
        this.profile = profile;
    }


}
