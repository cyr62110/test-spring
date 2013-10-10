package test.spring.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import test.spring.entities.Message;

public interface MessageRepository extends GraphRepository<Message> {
}
