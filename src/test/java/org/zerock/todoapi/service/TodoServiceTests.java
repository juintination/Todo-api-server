package org.zerock.todoapi.service;

import lombok.extern.log4j.Log4j2;
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
    public void testGet() {
        Long tno = 50L;
        log.info(todoService.get(tno));
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Title..")
                .content("Content..")
                .dueDate(LocalDate.of(2024, 3, 12))
                .build();
        log.info(todoService.register(todoDTO));
    }

    @Test
    public void testGetList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(todoService.getList(pageRequestDTO));
    }

}
