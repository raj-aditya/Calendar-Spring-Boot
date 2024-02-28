package com.example.Calendar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Calendar.model.Content;

@Repository
public class ContentJdbcRepository {

    private final  JdbcTemplate jdbcTemplate;

    public ContentJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(rs.getInt(columnLabel: "id"),
                rs.getString(columnLabel: "title"),
                rs.getString(columnLabel: "desc"),
                rs.getString(columnLabel: "status"),
                rs.getString(columnLabel: "content_type"),
                rs.getString(columnLabel: "data_created"),
                rs.getString(columnLabel: "data_updated"),
                rs.getString(columnLabel: "url"));
        
    }
    
    public List<Content> getAllContent(){
        String sql = "SELECT * FROM Content";
        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcRepository::mapRow);
        return contents;
        
    }
    
}
