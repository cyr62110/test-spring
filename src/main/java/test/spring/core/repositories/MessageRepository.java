package test.spring.core.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import test.spring.core.entities.Message;


public interface MessageRepository extends GraphRepository<Message> {

    @Query("START n = node(*) WHERE n.__type__ = 'test.spring.core.entities.Message' RETURN n ORDER BY n.date DESC LIMIT 10")
    public Iterable<Message> getPreviousMessages();
}
