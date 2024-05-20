package com.devock.mallapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devock.mallapi.domain.Todo;
import com.devock.mallapi.dto.TodoDTO;
import com.devock.mallapi.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor // 생성자 자동 주입
public class TodoServiceImpl implements TodoService {

    // 자동 주입 대상은 final로
    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;

    @Override 
    public Long register(TodoDTO todoDTO) {
        log.info("............");

        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        
        return savedTodo.getTno();
    }
    
}
