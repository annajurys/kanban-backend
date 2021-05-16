package pl.jurys.kanbanbackend.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Columns")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long columnId;

    public long getColumnId() {
        return columnId;
    }

    public void setColumnId(long id) {
        this.columnId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    public Column() {
    }

    public Column(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
