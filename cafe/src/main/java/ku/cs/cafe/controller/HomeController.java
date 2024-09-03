package ku.cs.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("greeting", "Hello World");

        // return file home.html
        return "home";
    }
}
