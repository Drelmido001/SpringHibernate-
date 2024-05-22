package com.example.springhibernate.Services;

import com.example.springhibernate.Models.InformationPerso;
import com.example.springhibernate.Repository.InfoPersoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InformationService {
    private final InfoPersoRepo informationRepository;

    public InformationService(InfoPersoRepo informationRepository) {
        this.informationRepository = informationRepository;
    }


    public List<InformationPerso> findAllInformations(){
        return informationRepository.findAll();
    }
    public InformationPerso findById(Long id){
        return informationRepository.findById(id);
    }


    public String deleteInformations(Long id){
        return informationRepository.deleteById(id);
    }

    public InformationPerso saveInformation(InformationPerso companies){
        return informationRepository.save(companies);
    }

    public InformationPerso updateInformation(InformationPerso companies){
        return informationRepository.update(companies);
    }
}
