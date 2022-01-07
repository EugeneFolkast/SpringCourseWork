package course.work.meogol.controller;

import course.work.meogol.dao.DishDAO;
import course.work.meogol.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashierController {
    private final DishDAO personDAO;
    private final OrderDAO orderDAO;


    @Autowired
    public CashierController(DishDAO personDAO, OrderDAO orderDAO) {
        this.personDAO = personDAO;
        this.orderDAO = orderDAO;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("dishes", orderDAO.index());
        return "meogol/test";
    }

}
