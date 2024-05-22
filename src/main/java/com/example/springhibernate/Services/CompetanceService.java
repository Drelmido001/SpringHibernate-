package com.example.springhibernate.Services;

import com.example.springhibernate.Models.Competance;
import com.example.springhibernate.Repository.CompetanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompetanceService {
    private final CompetanceRepo CompetanceRepository;

    public CompetanceService(CompetanceRepo skillsRepository) {
        this.CompetanceRepository = skillsRepository;
    }

    public List<Competance> findAllSkills(){
        return CompetanceRepository.findAll();
    }
    public Competance findById(Long id){
        return CompetanceRepository.findById(id);
    }


    public String deleteSkills(Long id){
        return CompetanceRepository.deleteById(id);
    }

    public Competance saveSkills(Competance skills){
        return CompetanceRepository.save(skills);
    }

    public Competance updateSkills(Competance skills){
        return CompetanceRepository.update(skills);
    }

}