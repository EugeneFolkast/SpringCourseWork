package course.work.meogol.controller;

import course.work.meogol.dao.DishDAO;
import course.work.meogol.dao.OrderShowDAO;
import course.work.meogol.dao.OrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CashierController {
    private final DishDAO dishDAO;
    private final OrderShowDAO orderShowDAO;
    private final OrdersDAO ordersDAO;

    @Autowired
    public CashierController(DishDAO dishDAO, OrderShowDAO orderShowDAO, OrdersDAO ordersDAO) {
        this.dishDAO = dishDAO;
        this.orderShowDAO = orderShowDAO;
        this.ordersDAO = ordersDAO;
    }

    @GetMapping("/all_orders")
    public String all_orders(Model model) {
        model.addAttribute("dishes", orderShowDAO.index());
        return "all_orders";
    }

    @GetMapping("/dish")
    public String dish(Model model) {
        model.addAttribute("dishes", dishDAO.index());
        return "meogol/dish";
    }

    @GetMapping("/add_orders")
    public String orders() {
        ordersDAO.openOrder();
        return "meogol/order";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("orders", ordersDAO.showAll());
        return "meogol/orders";
    }
}
