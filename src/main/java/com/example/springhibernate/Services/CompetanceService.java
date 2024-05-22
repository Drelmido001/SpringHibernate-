package com.example.springhibernate.Services;

import com.example.springhibernate.Models.Competance;

import com.example.springhibernate.Repository.CompetanceRepo;
import com.example.springhibernate.Services.GeneriqueService.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CompetanceService extends ServiceImpl<Competance, Long> {
    public CompetanceService(CompetanceRepo competanceRepo) {
        super(competanceRepo);
    }


}