package test.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.spring.entities.Message;
import test.spring.repositories.MessageRepository;

@Controller
@RequestMapping("/")
public class GoldenBookController {

    @Autowired
    private MessageRepository messageRepository;

    private Message message = new Message();

    @RequestMapping(method = RequestMethod.GET)
    public String getGoldenBook()
    {
        return "/goldenBook";
    }

    @ModelAttribute("message")
    public Message getMessage() {
        return message;
    }
}
