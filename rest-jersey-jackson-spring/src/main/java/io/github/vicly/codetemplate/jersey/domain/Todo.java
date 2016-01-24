package io.github.vicly.codetemplate.jersey.domain;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import io.github.vicly.codetemplate.jersey.domain.exceptions.StatusTransitionException;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

/**
 *
 * @author Vic Liu
 */
public class Todo {

    private UUID id;
    private TodoStatus status = TodoStatus.PENDING;
    private String description;
    private Date createdAt;
    private Date modifiedAt;

    public Todo() {
        this.id = UUID.randomUUID();
    }

    public Todo(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void transit(TodoStatus newStatus) throws StatusTransitionException {
        checkNotNull(newStatus);
        boolean fromCompleteToPending = (
                newStatus == TodoStatus.PENDING
                && this.status == TodoStatus.COMPLETE);
        if (fromCompleteToPending) {
            throw new StatusTransitionException(status, newStatus);
        }
        this.status = newStatus;
    }

    //CHECKSTYLE:OFF
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //CHECKSTYLE:ON
}
