package pl.pwlctk.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {

        return "index";
    }

    @RequestMapping("/{name}")
    public String sayHelloToYou(@PathVariable String name, Model model) {

        model.addAttribute("visitor", name);
        return "index";
    }
}
