package org.zerock.todoapi.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.todoapi.domain.Todo;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testIsNull() {
        Assertions.assertNotNull(todoRepository);
        log.info(todoRepository.getClass().getName());
    }

    @Test
    @BeforeEach
    public void testInsert() {
        for (int i = 0; i < 100; i++) {
            Todo todo = Todo.builder()
                    .title("Title.." + (i + 1))
                    .content("Content.." + (i + 1))
                    .dueDate(LocalDate.of(2024, 3, 12))
                    .build();

            Todo result = todoRepository.save(todo);
            log.info(result);
        }
    }

    @Test
    public void testRead() {

        Long tno = 1L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        Assertions.assertNotNull(todo);
        log.info(todo);

    }

    @Test
    public void testUpdate() {

        Long tno = 1L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        todo.changeTitle("updated title");
        todo.changeContent("updated content");
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2023,10,10));

        Assertions.assertNotNull(todoRepository.save(todo));
        log.info(todo);

    }

    @Test
    public void testPaging() {

        // 페이지 번호는 0부터
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);
        log.info(result.getTotalElements());
        log.info(result.getContent());

    }

}
