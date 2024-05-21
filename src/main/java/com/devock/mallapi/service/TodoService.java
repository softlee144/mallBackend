package com.devock.mallapi.service;

import com.devock.mallapi.dto.PageRequestDTO;
import com.devock.mallapi.dto.PageResponseDTO;
import com.devock.mallapi.dto.TodoDTO;

public interface TodoService {
    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
