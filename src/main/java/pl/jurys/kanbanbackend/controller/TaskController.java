package pl.jurys.kanbanbackend.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jurys.kanbanbackend.model.Column;
import pl.jurys.kanbanbackend.model.Task;
import pl.jurys.kanbanbackend.model.User;
import pl.jurys.kanbanbackend.repository.ColumnRepository;
import pl.jurys.kanbanbackend.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @GetMapping("")
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return this.taskRepository.findTasksByUserId(userId);
    }

    @GetMapping("/column/{userId}/{columnId}")
    public List<Task> getTasksByColumnId(@PathVariable Long userId, @PathVariable Long columnId) {
        return this.getTasksByUserId(userId).stream().filter(t -> t.getColumn().getColumnId() == columnId).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return this.taskRepository.findById(id);
    }

    @PostMapping("")
    public void addTask(@RequestBody Task task) {
        task.setColumn(columnRepository.findColumnByColumnId(1L));
        taskRepository.save(task);
    }

    @PutMapping(value = "/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Task taskToUpdate = taskRepository.findTaskByTaskId(taskId);
        if (task.getColumn() != null) {
            Column columnBefore = columnRepository.findColumnByColumnId(task.getColumn().getColumnId());
            String colName = columnBefore.getName();
            User user = columnBefore.getUser();
            taskToUpdate.setColumn(task.getColumn());
            taskRepository.save(taskToUpdate);
            Column columnAfter = columnRepository.findColumnByColumnId(taskToUpdate.getColumn().getColumnId());
            columnAfter.setUser(user);
            columnAfter.setName(colName);
            columnRepository.save(columnAfter);
        }
        if (task.getContent() != null) {
            taskToUpdate.setContent(task.getContent());
        }
        if (task.getTitle() != null) {
            taskToUpdate.setTitle(task.getTitle());
        }
        if (task.getStartDate() != null) {
            taskToUpdate.setStartDate(task.getStartDate());
        }
        if (task.getEndDate() != null) {
            taskToUpdate.setEndDate(task.getEndDate());
        }
        taskRepository.save(taskToUpdate);
    }

    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable Long taskId) throws NotFoundException {
        Task task = taskRepository.findTaskByTaskId(taskId);
        if(task == null) throw new NotFoundException(taskId.toString());
        taskRepository.delete(task);
    }
}
