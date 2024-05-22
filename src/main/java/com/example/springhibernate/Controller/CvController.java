package com.example.springhibernate.Controller;

import com.example.springhibernate.Exceptions.RequestException;
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

    @GetMapping("findAll")
    public ResponseEntity<List<Cv>> findAll()  {
        return ResponseEntity.ok().body(resumeSevice.findAll());
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)  {
        if(resumeSevice.findById(id)==null){
            throw new RequestException("L id ne se trouve pas",HttpStatus.NOT_FOUND);
        }
         resumeSevice.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody Cv resume) {
        resumeSevice.save(resume);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resume added successfully.");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Cv> updateResume(@RequestBody Cv resume) {
        return ResponseEntity.ok().body(resumeSevice.update(resume));
    }
}
