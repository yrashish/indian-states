package com.example.indianstates;

import java.util.List;

public interface StateRepository {
    List<State> findAll();

    String findByName(String name);
}
