package com.example.springhibernate.Services;


import com.example.springhibernate.Models.Cv;
import com.example.springhibernate.Repository.CvRepo;
import com.example.springhibernate.Services.GeneriqueService.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CvService extends ServiceImpl<Cv, Long> {
    public CvService(CvRepo cvRepo) {
        super(cvRepo);
    }
}