package com.devock.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devock.mallapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
