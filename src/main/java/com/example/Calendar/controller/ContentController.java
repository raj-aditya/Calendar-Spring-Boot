package com.example.Calendar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Calendar.model.Content;
import com.example.Calendar.repository.ContentControllerRepository;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(
    "api/content"
)
public class ContentController {

    private final ContentControllerRepository repository;
    
    public ContentController(ContentControllerRepository repository){
        this.repository = repository;
    }
 
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
        
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findbyId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
        

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create (@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        
       if(!repository.existById(id)){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
       }

       repository.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        repository.delete(id);
        }



}
    

    

