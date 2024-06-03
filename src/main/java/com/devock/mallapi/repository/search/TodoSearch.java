package com.devock.mallapi.repository.search;

import org.springframework.data.domain.Page;

import com.devock.mallapi.domain.Todo;

public interface TodoSearch {

    Page<Todo> search1();

}
