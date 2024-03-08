package com.anamenezes.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.anamenezes.todolist.entity.Todo;
import com.anamenezes.todolist.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository repo;
	
	public TodoService(TodoRepository repo) {
		this.repo = repo;
	}
	
	public List<Todo> create(Todo todo){
		repo.save(todo);
		return list();
	}
	
	public List<Todo> list(){
		Sort sort = Sort.by(Direction.DESC, "priority").and(Sort.by(Direction.ASC, "name"));
		return repo.findAll(sort);
	}
	
	public List<Todo> update(Todo todo){
		repo.save(todo);
		return list();
	}
	
	public List<Todo> delete(Long id){
		repo.deleteById(id);
		return list();
	}
}