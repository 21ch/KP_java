package todolist.repositories.services;

import org.springframework.stereotype.Service;

import todolist.models.task;
import todolist.repositories.task_repository;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class Task_service {
    @Autowired
    private task_repository taskrepository;

    public Task get_task_by_id(Integer id) { return taskrepository.findById(id).get();}
    public List<Task> get_all_tasks(){
        return taskrepository.findAll();
    }
    public void save_task(Task task){
        taskrepository.save(task);
    }
    public void delete_task(Integer id){
        taskrepository.deleteById(id);
    }

}
