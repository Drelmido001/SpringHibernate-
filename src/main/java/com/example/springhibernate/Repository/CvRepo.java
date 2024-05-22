package com.example.springhibernate.Repository;


import com.example.springhibernate.Models.Cv;

import com.example.springhibernate.Repository.Generetic.GenererImpl;
import org.springframework.stereotype.Repository;


@Repository
public class CvRepo extends GenererImpl<Cv, Long> {
    public CvRepo(){
    super(Cv.class);
    }

}
