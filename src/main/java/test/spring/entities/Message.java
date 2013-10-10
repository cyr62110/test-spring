package test.spring.entities;

import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created with IntelliJ IDEA.
 * User: dizen_000
 * Date: 10/10/13
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@NodeEntity
public class Message {
    @GraphId Long id;

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
