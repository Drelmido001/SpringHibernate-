package com.example.springhibernate.Controller;

import com.example.springhibernate.Models.Cv;
import com.example.springhibernate.Services.CvService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cvs")
public class CvController {

    private final CvService resumeSevice;

    public CvController(CvService resumeSevice) {
        this.resumeSevice = resumeSevice;
    }

    @GetMapping("/")
    public ResponseEntity<List<Cv>> list()  {
        return ResponseEntity.ok().body(resumeSevice.findAllResumes());
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id)  {
        return resumeSevice.deleteResume(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Cv resume) {
        resumeSevice.saveResume(resume);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resume added successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cv> updateResume(@RequestBody Cv resume) {
        return ResponseEntity.ok().body(resumeSevice.updateResume(resume));
    }
}
