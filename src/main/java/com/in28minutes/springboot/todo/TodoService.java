package com.in28minutes.springboot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todosCount =0;
	static {
		todos.add(new Todo(++todosCount, "in28minutes", "learn java",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn AWS",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn Python",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn JavaScript",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn Devops",
						LocalDate.now().plusYears(1),false));
				
	}

	
	
	public List<Todo> findByUsername(String username){
		return todos;
	}

	public void addTodo(String username, String description, LocalDate target, boolean done) {
		// TODO Auto-generated method stub
		
		Todo todo = new Todo(++todosCount,username,description,target,done);
		todos.add(todo);
	}
}

