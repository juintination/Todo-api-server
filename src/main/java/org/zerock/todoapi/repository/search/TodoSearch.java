package org.zerock.todoapi.repository.search;

import org.springframework.data.domain.Page;
import org.zerock.todoapi.domain.Todo;
import org.zerock.todoapi.dto.PageRequestDTO;

public interface TodoSearch {
    Page<Todo> searchByPage(PageRequestDTO pageRequestDTO);
}
