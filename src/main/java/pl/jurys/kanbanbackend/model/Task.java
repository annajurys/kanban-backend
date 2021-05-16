package pl.jurys.kanbanbackend.model;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "column_id")
    private Column column;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @javax.persistence.Column(name = "user_id")
    private long userId;

    private String title;

    private String content;
    @javax.persistence.Column(name = "start_date")
    private Date startDate;

    public Task(Column column, Long userId, String title, String content, Date startDate, Date endDate) {
        this.column = column;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @javax.persistence.Column(name = "end_date")
    private Date endDate;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long id) {
        this.taskId = id;
    }

    public Task() {}

}
