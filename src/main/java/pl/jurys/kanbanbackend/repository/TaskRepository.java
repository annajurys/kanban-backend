package pl.jurys.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jurys.kanbanbackend.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUserId(Long userId);
    Task findTaskByTaskId(Long taskId);
}
