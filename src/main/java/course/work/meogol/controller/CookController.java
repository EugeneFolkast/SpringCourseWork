package course.work.meogol.controller;

import course.work.meogol.dao.OrderShowDAO;
import course.work.meogol.dao.OrdersDishDAO;
import course.work.meogol.model.Orders;
import course.work.meogol.model.OrdersDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Controller
public class CookController {
    private final OrderShowDAO orderShowDAO;
    private final OrdersDishDAO ordersDishDAO;

    @Autowired
    public CookController(OrderShowDAO orderShowDAO, OrdersDishDAO ordersDishDAO) {
        this.orderShowDAO = orderShowDAO;
        this.ordersDishDAO = ordersDishDAO;
    }

    @GetMapping("/cook_orders")
    public String all_orders(Model model) {
        model.addAttribute("dishes", ordersDishDAO.showAll("ГОТОВИТСЯ"));
        model.addAttribute("completeDishes", ordersDishDAO.showAll("ГОТОВ"));
        return "meogol/all_orders";
    }

    @PatchMapping("/update_order_status/{odId}/{status}")
    public String update_order_dish(@PathVariable("odId") int id, @PathVariable("status") String status){
        if (Objects.equals(status, "ГОТОВИТСЯ"))
            status = "ГОТОВ";
        else
            status = "ГОТОВИТСЯ";

        ordersDishDAO.updateStatus(id, status);

        return "redirect:/cook_orders";
    }
}
