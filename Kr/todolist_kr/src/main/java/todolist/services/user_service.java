package todolist.repositories.services;

import org.springframework.stereotype.Service;

import todolist.models.user;
import todolist.repositories.user_repository;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class User_service {
    @Autowired
    private user_repository userrepository;

    public User get_user_by_id(Integer id){
        return userrepository.findById(id).get();
    }
    public List<User> get_all_users(){
        return userrepository.findAll();
    }
    public void save_user(User user){
        userrepository.save(user);
    }
    public void delete_user(Integer id){
        userrepository.deleteById(id);
    }

}
