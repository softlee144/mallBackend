package com.devock.mallapi.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.devock.mallapi.domain.QTodo;
import com.devock.mallapi.domain.Todo;
import com.devock.mallapi.dto.PageRequestDTO;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDTO pageRequestDTO) {

        log.info("search1............");
        log.info(pageRequestDTO);

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        // query.where(todo.title.contains("1"));

        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() - 1, pageRequestDTO.getSize(),
                Sort.by("tno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }
}
