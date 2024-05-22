package com.example.springhibernate.Repository;


import com.example.springhibernate.Models.InformationPerso;
import com.example.springhibernate.Repository.Generetic.GenererImpl;

import org.springframework.stereotype.Repository;


@Repository
public class InfoPersoRepo extends GenererImpl<InformationPerso, Long> {

    public InfoPersoRepo() {
        super(InformationPerso.class);
    }
}
