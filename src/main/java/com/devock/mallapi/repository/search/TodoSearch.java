package com.devock.mallapi.repository.search;

import org.springframework.data.domain.Page;

import com.devock.mallapi.domain.Todo;
import com.devock.mallapi.dto.PageRequestDTO;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);

}
