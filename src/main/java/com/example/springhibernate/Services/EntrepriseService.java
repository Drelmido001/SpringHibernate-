package com.example.springhibernate.Services;

import com.example.springhibernate.Models.Entreprise;
import com.example.springhibernate.Repository.EntrepriseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntrepriseService {


    private final EntrepriseRepo companiesRepository;

    public EntrepriseService(EntrepriseRepo companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    public List<Entreprise> findAllCompanies(){
        return companiesRepository.findAll();
    }
    public Entreprise findById(Long id){
        return companiesRepository.findById(id);
    }


    public String deleteCompanies(Long id){
        return companiesRepository.deleteById(id);
    }

    public Entreprise saveCompany(Entreprise companies){
        return companiesRepository.save(companies);
    }

    public Entreprise updateCompany(Entreprise companies){
        return companiesRepository.update(companies);
    }

}