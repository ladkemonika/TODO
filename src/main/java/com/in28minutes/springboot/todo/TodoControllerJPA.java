package com.in28minutes.springboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		//this.todoService = todoService;
		this.todoRepository=todoRepository;
	}
	
	//private TodoService todoService;
	
	private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String ListAllTodos(ModelMap model) {
		String username= getLoggedInUsername(model);
		System.out.println("Logged in user: " + username);
		List<Todo> todos = todoRepository.findByUsername(username);
		System.out.println("Todos retrieved: " + todos);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}

	
	
	@RequestMapping(value="add-todo",method= RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= getLoggedInUsername(model);
		Todo todo = new Todo(0, username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method= RequestMethod.POST)
	public String AddNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String username= getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		/*
		 * todoService.addTodo(username,todo.getDescription(),
		 * todo.getTarget(),todo.isDone());
		 */
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam("id")  int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method= RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam("id") int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "todo";
	}
	@RequestMapping(value="update-todo",method= RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username= getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		

	}
}
