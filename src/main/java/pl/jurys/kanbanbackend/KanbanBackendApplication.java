package pl.jurys.kanbanbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.jurys.kanbanbackend.model.Column;
import pl.jurys.kanbanbackend.model.Task;
import pl.jurys.kanbanbackend.model.User;
import pl.jurys.kanbanbackend.repository.ColumnRepository;
import pl.jurys.kanbanbackend.repository.TaskRepository;
import pl.jurys.kanbanbackend.repository.UserRepository;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class KanbanBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KanbanBackendApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ColumnRepository columnRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User("Anna", "J", "anna.j@gmail.com", "aaa"));
        this.userRepository.save(new User("Tomasz", "G", "tomasz.g@gmail.com", "aaa"));
        this.userRepository.save(new User("Klaudia", "K", "klaudia.k@gmail.com", "aaa"));
        this.columnRepository.save(new Column(userRepository.getOne(1L), "ToDo"));
        this.columnRepository.save(new Column(userRepository.getOne(1L), "Doing"));
        this.columnRepository.save(new Column(userRepository.getOne(1L), "Done"));this.taskRepository.save(new Task(columnRepository.getOne(1L), 1L, "Watch TV", "15:00", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(2L), 1L, "Do task list", "Immediatly!", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(2L), 1L, "Visit mom", "Call her when I will go", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(3L), 1L, "Make dinner", "at 15:00", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(3L), 1L, "Feed cats", "Zako", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(1L), 1L, "Visit grandma", "Make her cake", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(1L), 1L, "Watch TV", "Movie time", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(1L), 1L, "Clean room", "Home duties", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
        this.taskRepository.save(new Task(columnRepository.getOne(1L), 1L, "Be happy!", "Dont worry!", new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("27/10/2020")));
     }
}
