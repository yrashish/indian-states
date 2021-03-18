package com.example.indianstates;

import java.util.List;

public interface StateRepository {
    List<State> findAll();
    State findByName(String name);
}
