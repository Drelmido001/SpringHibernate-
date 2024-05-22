package com.example.springhibernate.Repository;


import com.example.springhibernate.Models.Entreprise;
import com.example.springhibernate.Repository.Generetic.GenererImpl;
import org.springframework.stereotype.Repository;


@Repository
public class EntrepriseRepo extends GenererImpl<Entreprise, Long> {

    public EntrepriseRepo() {
        super(Entreprise.class);
    }
}
