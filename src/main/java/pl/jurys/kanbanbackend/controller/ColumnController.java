package pl.jurys.kanbanbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jurys.kanbanbackend.model.Column;
import pl.jurys.kanbanbackend.repository.ColumnRepository;
import pl.jurys.kanbanbackend.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/column")
public class ColumnController {

    @Autowired
    private ColumnRepository columnRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<Column> getColumns() {
        return this.columnRepository.findAll();
    }

    @GetMapping("/{columnId}")
    public Column getColumnById(@PathVariable Long columnId) {
        return this.columnRepository.findColumnByColumnId(columnId);
    }

//    @GetMapping("{columnId}/name")
//    public String getColumnName(@PathVariable Long columnId) {
//        return this.columnRepository.findColumnById(columnId).getName();
//    }

    @PostMapping("")
    public void addColumn(@RequestBody Column column) {
        column.setUser(userRepository.findUserByUserId(1L));//TODO: zmień na serio dobry user
        columnRepository.save(column);
    }

    @PutMapping(value = "/{columnId}")
    public void updateColumn(@PathVariable Long columnId, @RequestBody Column column) {
        Column columnToUpdate = columnRepository.findColumnByColumnId(columnId);
        if(column.getName()!=null) {
            columnToUpdate.setName(column.getName());
        }
        columnRepository.save(columnToUpdate);
    }

    @Transactional
    @DeleteMapping(value = "/{columnId}")
    public void deleteColumn(@PathVariable Long columnId) {
        columnRepository.deleteColumnByColumnId(columnId);
    }
}
