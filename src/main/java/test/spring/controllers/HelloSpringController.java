package test.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.spring.entities.Message;
import test.spring.repositories.MessageRepository;

@Controller
@RequestMapping("/")
public class HelloSpringController {

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloSpring()
    {
        Message m = new Message("Mon message");
        messageRepository.save(m);
        return m.toString();
    }

}
