package todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.models.user;

public interface user_repository extends JpaRepository<User, Integer>{
    
}
