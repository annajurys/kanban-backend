package pl.jurys.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jurys.kanbanbackend.model.Column;

public interface ColumnRepository extends JpaRepository<Column, Long> {
    Column findColumnByColumnId(Long columnId);
    void deleteColumnByColumnId(Long columnId);
}
