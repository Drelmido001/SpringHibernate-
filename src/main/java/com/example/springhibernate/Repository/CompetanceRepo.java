package com.example.springhibernate.Repository;


import com.example.springhibernate.Models.Competance;
import com.example.springhibernate.Models.Entreprise;
import com.example.springhibernate.Repository.Generetic.GenererImpl;
import org.springframework.stereotype.Repository;


@Repository
public class CompetanceRepo extends GenererImpl<Competance, Long> {

    public CompetanceRepo() {
        super(Competance.class);
    }
}
