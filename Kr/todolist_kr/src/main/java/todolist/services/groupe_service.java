package todolist.repositories.services;

import org.springframework.stereotype.Service;

import todolist.models.City;
import todolist.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class Groupe_service {
    @Autowired
    private groupe_repository grouperepository;

    public Groupe get_groupe_by_id(Integer id){
        return grouperepository.findById(id).get();
    }
    public List<Groupe> get_all_groupes() { return grouperepository.findAll();}
    public void save_groupe(Groupe groupe){
        grouperepository.save(groupe);
    }
    public void delete_groupe(Integer id){
        grouperepository.deleteById(id);
    }

}
