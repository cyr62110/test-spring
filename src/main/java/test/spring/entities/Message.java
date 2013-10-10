package test.spring.entities;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Date;

@NodeEntity
public class Message {

    @GraphId
    private Long id;

    private Date date;

    private String message;

    public Message() {
        date = new Date();
    }

    public Message(String message) {
        this();
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
