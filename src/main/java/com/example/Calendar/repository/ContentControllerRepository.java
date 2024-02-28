package com.example.Calendar.repository;

import org.springframework.stereotype.Repository;

import com.example.Calendar.model.Content;
import com.example.Calendar.model.Status;
import com.example.Calendar.model.Type;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;


@Repository
public class ContentControllerRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentControllerRepository(){

    }

    public List<Content> findAll(){

        return contentList;

    }

    public Optional<Content> findbyId(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }


    @PostConstruct
    private void init(){
        Content c = new Content(1, "My first post", "My first post", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
        contentList.add(c);
        
    }
    

    
}



    

