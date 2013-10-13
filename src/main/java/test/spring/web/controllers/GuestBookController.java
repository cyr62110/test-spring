package test.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.spring.core.entities.Message;
import test.spring.core.repositories.MessageRepository;
import test.spring.web.entities.WebMessage;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class GuestBookController {

    private MessageRepository messageRepository;

    @Autowired
    public GuestBookController(MessageRepository messageRepository)
    {
        this.messageRepository = messageRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGoldenBook()
    {
        return "/guestBook";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postMessage(@ModelAttribute("message") Message message)
    {
        messageRepository.save(message);
        return "redirect:/";
    }

    @ModelAttribute("previousMessages")
    public Iterable<WebMessage> getPreviousMessages()
    {
        ArrayList<WebMessage> messages = new ArrayList<WebMessage>();
        for(Message m : messageRepository.getPreviousMessages())
        {
            messages.add(new WebMessage(m));
        }
        return messages;
    }


}
