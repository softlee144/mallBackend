package com.devock.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devock.mallapi.domain.Todo;
import com.devock.mallapi.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
