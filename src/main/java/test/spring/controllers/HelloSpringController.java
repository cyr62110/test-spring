package test.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloSpringController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloSpring()
    {
        return "Hello Spring";
    }

}
