package io.github.vicly.codetemplate.jersey.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import io.github.vicly.codetemplate.jersey.api.model.TodoStatusChange;
import io.github.vicly.codetemplate.jersey.domain.Todo;
import io.github.vicly.codetemplate.jersey.domain.TodoService;

/**
 *
 * @author Vic Liu
 */
@Component
@Path("/todos")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TodoResource {

    private TodoService todoService;

    @Context
    private UriInfo uriInfo;

    @Autowired
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    public List<Todo> findAll() {
        return this.todoService.findAll();
    }

    // ba4f0783-b42f-4d30-be58-e26a1fb9a12a
    // TODO: bean validation
    // TODO: customize
    @GET
    @Path("{id}")
    public Todo getTodoById(@PathParam("id") UUID id) {
        return this.todoService.getTodoById(id);
    }

    @POST
    @Valid
    public Response createTodo(Todo todo) {
        this.todoService.createTodo(todo);

        UUID id = todo.getId();
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI todoUri = ub.path(id.toString()).build();
        return Response.created(todoUri).build();
    }

    @POST
    @Path("{id}/status-changes")
    public Response updateTodoStatus(@PathParam("id") UUID id, TodoStatusChange statusChange) {
        this.todoService.changeTodoStatus(id, statusChange.getStatus());
        URI todoUri = uriInfo.getBaseUriBuilder()
                .path(TodoResource.class)
                .path(id.toString())
                .build();
        return Response.seeOther(todoUri).build();
    }

}
