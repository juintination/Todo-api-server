package org.zerock.todoapi.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.todoapi.domain.Todo;
import org.zerock.todoapi.dto.PageRequestDTO;
import org.zerock.todoapi.dto.PageResponseDTO;
import org.zerock.todoapi.dto.TodoDTO;

@Transactional
public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    default TodoDTO entityToDTO(Todo todo) {

        return TodoDTO.builder()
                .tno(todo.getTno())
                .regDate(todo.getRegDate())
                .modDate(todo.getModDate())
                .title(todo.getTitle())
                .content(todo.getContent())
                .complete(todo.isComplete())
                .dueDate(todo.getDueDate())
                .build();

    }

    default Todo dtoToEntity(TodoDTO todoDTO) {

        return Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();

    }

}
