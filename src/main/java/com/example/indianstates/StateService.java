package com.example.indianstates;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements StateRepository{
    private final JdbcTemplate jdbcTemplate;

    public StateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<State>  rowMapper = (rs, rowNum) -> new State(rs.getString("name"),rs.getString("capital"));

    @Override
    public List<State> findAll() {
        String findAllStates = """
                select * from States
                """;
        return jdbcTemplate.query(findAllStates, rowMapper);
    }

    @Override
    public State findByName(String name) {
        String findByName = """
                select * from States where name = ?;
                """;
        return jdbcTemplate.queryForObject(findByName,rowMapper, name);
    }
}
