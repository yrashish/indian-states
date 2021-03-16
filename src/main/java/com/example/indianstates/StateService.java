package com.example.indianstates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements StateRepository{
    private final JdbcTemplate jdbcTemplate;

    public StateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<State> findAll() {
        return jdbcTemplate.query("select * from States", new BeanPropertyRowMapper<>(State.class));
    }
}
