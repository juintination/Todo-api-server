package org.zerock.todoapi.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.todoapi.domain.Todo;
import org.zerock.todoapi.dto.PageRequestDTO;
import org.zerock.todoapi.dto.TodoDTO;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    @BeforeEach
    public void testRegister() {
        for (int i = 0; i < 100; i++) {
            TodoDTO todoDTO = TodoDTO.builder()
                    .title("Title.." + (i + 1))
                    .content("Content.." + (i + 1))
                    .dueDate(LocalDate.of(2024, 3, 12))
                    .build();
            log.info(todoService.register(todoDTO));
        }
    }

    @Test
    public void testGet() {
        Long tno = 50L;
        TodoDTO todoDTO = todoService.get(tno);
        Assertions.assertNotNull(todoDTO);
        log.info(todoDTO);
    }

    @Test
    public void testGetList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        Assertions.assertNotNull(pageRequestDTO);
        log.info(todoService.getList(pageRequestDTO));
    }

}
