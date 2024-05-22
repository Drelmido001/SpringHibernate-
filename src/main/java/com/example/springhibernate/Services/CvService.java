package com.example.springhibernate.Services;

import com.example.springhibernate.Models.Competance;
import com.example.springhibernate.Models.Cv;
import com.example.springhibernate.Models.Entreprise;
import com.example.springhibernate.Repository.CompetanceRepo;
import com.example.springhibernate.Repository.CvRepo;
import com.example.springhibernate.Repository.EntrepriseRepo;
import com.example.springhibernate.Repository.InfoPersoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvService {


    private final CvRepo resumeRepository;
    private final CompetanceRepo competanceRepo;
    private final EntrepriseRepo entrepriseRepo;
    private final InfoPersoRepo informationRepository;

    public CvService(CvRepo resumeRepository, CompetanceRepo competanceRepo,  EntrepriseRepo entrepriseRepo, InfoPersoRepo informationRepository) {
        this.resumeRepository = resumeRepository;
        this.competanceRepo = competanceRepo;
        this.entrepriseRepo = entrepriseRepo;
        this.informationRepository = informationRepository;
    }

    public List<Cv> findAllResumes(){
        return resumeRepository.findAll();
    }
    public Cv findById(Long id){
        return resumeRepository.findById(id);
    }


    public String deleteResume(Long id){
        return resumeRepository.deleteById(id);
    }

    public Cv saveResume(Cv resume){
        for (Competance skill : resume.getCompetance()) {
            competanceRepo.save(skill);
        }
        for (Entreprise company : resume.getCompaniesList()) {
            entrepriseRepo.save(company);
        }
        informationRepository.save(resume.getInformation());
        return resumeRepository.save(resume);
    }

    public Cv updateResume(Cv resume){
        for (Competance skill : resume.getCompaniesList()) {
            competanceRepo.update(skill);
        }
        for (Entreprise company : resume.getCompaniesList()) {
            entrepriseRepo.update(company);
        }
        informationRepository.update(resume.getInformation());
        return resumeRepository.update(resume);
    }


}