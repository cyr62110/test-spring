package test.spring.web.controllers;

import static org.mockito.Mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;
import test.spring.core.entities.Message;
import test.spring.core.repositories.MessageRepository;
import test.spring.web.entities.WebMessage;

import java.util.ArrayList;
import java.util.Iterator;

@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/application-context.xml")
public class GuestBookControllerTest extends AbstractTestNGSpringContextTests {

    private GuestBookController guestBookController = null;
    private Iterable<Message> previousMessages = null;
    private Message message = null;

    @BeforeClass
    public void init()
    {
        message = new Message();
        message.setMessage("Test");
        message.setEmail("email@email.email");
        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(message);

        previousMessages = messages;
    }

    @Test
    public void unitTestGetPreviousMessage()
    {
        //init
        MessageRepository mockedMessageRepository = mock(MessageRepository.class);
        when(mockedMessageRepository.getPreviousMessages()).thenReturn(previousMessages);

        GuestBookController guestBookController = new GuestBookController(mockedMessageRepository);

        //when
        Message originalMessage =  previousMessages.iterator().next();
        Iterator<WebMessage> previousIterator = guestBookController.getPreviousMessages().iterator();

        //then
        Assert.assertTrue(previousIterator.hasNext());
        Assert.assertTrue(previousIterator.next().getMessage().equals(originalMessage.getMessage()));
    }

    @Test
    public void unitTestPostMessage()
    {
        //init
        MessageRepository mockedMessageRepository = mock(MessageRepository.class);
        when(mockedMessageRepository.save(message)).thenReturn(message);

        GuestBookController guestBookController = new GuestBookController(mockedMessageRepository);

        //when
        guestBookController.postMessage(message);

        //then
        verify(mockedMessageRepository).save(message);
    }
}
