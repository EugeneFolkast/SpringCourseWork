package meogol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashierController {

    @GetMapping("/n")
    public String index() {
        System.out.println("test");
        return "viewMainCashier";
    }
}
