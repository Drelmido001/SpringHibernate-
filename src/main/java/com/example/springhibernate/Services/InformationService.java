package com.example.springhibernate.Services;


import com.example.springhibernate.Models.InformationPerso;

import com.example.springhibernate.Repository.InfoPersoRepo;
import com.example.springhibernate.Services.GeneriqueService.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class InformationService extends ServiceImpl<InformationPerso, Long> {
    public InformationService( InfoPersoRepo infoPersoRepo) {
        super(infoPersoRepo);
    }
}
