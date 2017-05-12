package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/"})
public class HomeController {
    @RequestMapping(method = GET)
    public String home(Model model) {
        model.addAttribute("subject", "World");
        return "home";
    }
}