package todolist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="firstname", nullable = false)
    private String firstname;

    @ManyToOne
    @JoinColumn(name="lastname", nullable = false)
    private String lastname;

    @ManyToOne
    @JoinColumn(name="birthdate", nullable = false)
    private Date birthdate;
    public void update_user(User user){
        if (user.firstname != null) {
            this.firstname = user.firstname;
        }
        if (user.lastname != null) {
            this.lastname = user.lastname;
        }
        if (user.birthdate != null) {
            this.birthdate = user.birthdate;
        }
    }
}
