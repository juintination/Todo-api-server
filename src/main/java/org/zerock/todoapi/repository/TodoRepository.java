package org.zerock.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.todoapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
