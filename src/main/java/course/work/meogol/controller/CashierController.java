package course.work.meogol.controller;

import course.work.meogol.dao.DishDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashierController {
    private final DishDAO personDAO;

    @Autowired
    public CashierController(DishDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("dishes", personDAO.index());
        return "meogol/test";
    }

}
