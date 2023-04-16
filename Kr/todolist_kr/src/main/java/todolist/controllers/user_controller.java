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

import todolist.models.User;
import todolist.services.User_service;

@RestController
@RequestMapping("/users")
public class User_controller {
    @Autowired
    private User_service userservice;

    @GetMapping("")
    public List<User> get_all_users(){
        return userservice.get_all_users();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get_user_by_id(@PathVariable Integer id){
        try{
            User user = userservice.get_user_by_id(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }    }

    @PostMapping("/")
    public void add(@RequestBody User user){
        userservice.save_user(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
        try{
            User user = userservice.get_user_by_id(id);
            user1.update_user(user);
            userservice.save_user(user1);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userservice.deleteRoute(id);
    }
}
