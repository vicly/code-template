package io.github.vicly.codetemplate.jersey.domain;

import java.util.List;
import java.util.UUID;

import io.github.vicly.codetemplate.jersey.domain.exceptions.DuplicationException;
import io.github.vicly.codetemplate.jersey.domain.exceptions.NotFoundException;
import io.github.vicly.codetemplate.jersey.domain.exceptions.StatusTransitionException;

/**
 * use-case level encapsulation.
 *
 * @author Vic Liu
 */
public interface TodoService {

    /**
     * Create a new Todo
     *
     * @param todo not-null
     * @throws DuplicationException if there is a pending {@link Todo} with same description
     */
    void createTodo(Todo todo) throws DuplicationException;

    /**
     * Get Todo by id
     *
     * @param id the not-null id
     * @return the found Todo
     * @throws NotFoundException if not found by {@code id}
     */
    Todo getTodoById(UUID id) throws NotFoundException;

    /**
     * @throws StatusTransitionException if cannot status transition is illegal
     */
    void changeTodoStatus(UUID id, TodoStatus newStatus) throws StatusTransitionException;

    List<Todo> findAll();
}
