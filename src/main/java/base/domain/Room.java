package base.domain;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Check(constraints = "people < 3")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean available;
    private int people;
    private String subject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int users_num) {
        this.people = users_num;
    }


}
