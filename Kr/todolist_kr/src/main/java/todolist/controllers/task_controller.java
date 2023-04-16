package todolist.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.models.task;
import todolist.services.task_service;

@RestController
@RequestMapping("/tasks")
public class Task_controller {
    @Autowired
    private Task_service taskservice;

    @GetMapping("")
    public List<Task> get_all_tasks(){
        return taskservice.get_all_tasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get_task_by_id(@PathVariable Integer id){
        try{
            Task task = taskservice.get_task_by_id(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }    }

    @PostMapping("/")
    public void add(@RequestBody Task task){
        taskservice.save_task(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Integer id){
        try{
            Task task1 = taskservice.get_task_by_id(id);
            task1.update_task(task);
            taskservice.save_task(task1);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        taskservice.delete_task(id);
    }
}
