package io.github.vicly.codetemplate.jersey.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.github.vicly.codetemplate.jersey.domain.exceptions.DuplicationException;
import io.github.vicly.codetemplate.jersey.domain.exceptions.NotFoundException;
import io.github.vicly.codetemplate.jersey.domain.exceptions.StatusTransitionException;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Vic Liu
 */
@Service
public class TodoServiceImpl implements TodoService {

    private Map<UUID, Todo> db = new HashMap<>();

    @Override
    public void createTodo(Todo todo) {
        String description = todo.getDescription();
        for (Map.Entry<UUID, Todo> entry : db.entrySet()) {
            boolean isSameDescription = entry.getValue().getDescription().equals(description);
            boolean isPending = entry.getValue().getStatus() == TodoStatus.PENDING;
            if (isSameDescription && isPending) {
                throw new DuplicationException("Duplicate PENDING Todo found: id="
                        + entry.getKey());
            }
        }
        todo.setId(UUID.randomUUID());
        db.put(todo.getId(), todo);
    }

    @Override
    public Todo getTodoById(UUID id) {
        if (db.containsKey(checkNotNull(id))) {
            return db.get(id);
        }
        throw new NotFoundException("Cannot find Todo by id " + id);
    }

    @Override
    public void changeTodoStatus(UUID id, TodoStatus newStatus) throws StatusTransitionException {
        Todo todo = getTodoById(id);
        todo.transit(newStatus);
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(this.db.values());
    }

}
