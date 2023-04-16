package todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.models.task;

public interface task_repository extends JpaRepository<Task, Integer>{

}