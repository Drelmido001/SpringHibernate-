package com.example.springhibernate.Services;


import com.example.springhibernate.Models.Entreprise;
import com.example.springhibernate.Repository.EntrepriseRepo;
import com.example.springhibernate.Services.GeneriqueService.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EntrepriseService extends ServiceImpl<Entreprise, Long> {

    public EntrepriseService(EntrepriseRepo entrepriseRepo) {
        super(entrepriseRepo);
    }
}