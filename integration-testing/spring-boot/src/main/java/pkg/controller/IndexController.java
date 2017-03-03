package pkg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by pivotal on 3/3/17.
 */
@Controller
public class ViewController {
    @GetMapping("/")
    public String helloWorldView(Model model) {
        return "index";
    }
}
