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

import todolist.models.groupe;
import todolist.services.groupe_service;

@RestController
@RequestMapping("/groupes")
public class Groupe_controller {
    @Autowired
    private Groupe_service groupeservice;

    @GetMapping("")
    public List<Groupe> get_all_groupes(){
        return groupeservice.get_all_groupes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> get_groupe_by_id(@PathVariable Integer id){
        try{
            Groupe groupe = groupeservice.get_groupe_by_id(id);
            return new ResponseEntity<Groupe>(groupe, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Groupe>(HttpStatus.NOT_FOUND);
        }    }

    @PostMapping("/")
    public void add(@RequestBody Groupe groupe){
        groupeservice.save_groupe(groupe);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Groupe groupe, @PathVariable Integer id){
        try{
            Groupe groupe1  = groupeservice.get_groupe_by_id(id);
            groupe1.update_groupe(groupe);
            groupeservice.save_groupe(groupe1);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        groupeservice.delete_groupe(id);
    }

}
