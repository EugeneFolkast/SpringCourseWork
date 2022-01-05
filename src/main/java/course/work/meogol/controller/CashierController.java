package course.work.meogol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashierController {
    @GetMapping("/index")
    public String index() {
        System.out.println("sindexsss");
        return "meogol/test";
    }

}
