package com.acadgild.jersey.todo.dao;

import java.util.HashMap;
import java.util.Map;

import com.acadgild.jersey.todo.model.Todo;

public enum TodoDao {
    instance;

    private Map<String, Todo> contentProvider = new HashMap<>();

    private TodoDao() {

        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read rest book");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Do something");
        todo.setDescription("Read complete ");
        contentProvider.put("2", todo);

    }
    public Map<String, Todo> getModel(){
        return contentProvider;
    }

}