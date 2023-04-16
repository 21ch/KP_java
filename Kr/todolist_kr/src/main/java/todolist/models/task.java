package todolist.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date datetime;
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    public void update_task(Task task){
        if (task.name != null) {
            this.name = task.name;
        }
        if (task.description != null) {
            this.description = task.description;
        }
        if (task.datetime != null) {
            this.datetime = task.datetime;
        }
        if (task.done != null) {
            this.done = task.done;
        }
    }
}
