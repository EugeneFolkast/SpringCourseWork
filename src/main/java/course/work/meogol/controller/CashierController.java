package course.work.meogol.controller;

import course.work.meogol.dao.DishDAO;
import course.work.meogol.dao.OrderShowDAO;
import course.work.meogol.dao.OrdersDAO;
import course.work.meogol.dao.OrdersDishDAO;
import course.work.meogol.model.Dish;
import course.work.meogol.model.Orders;
import course.work.meogol.model.OrdersDish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class CashierController {
    private final DishDAO dishDAO;
    private final OrderShowDAO orderShowDAO;
    private final OrdersDAO ordersDAO;
    private final OrdersDishDAO ordersDishDAO;

    @Autowired
    public CashierController(DishDAO dishDAO, OrderShowDAO orderShowDAO, OrdersDAO ordersDAO, OrdersDishDAO ordersDishDAO) {
        this.dishDAO = dishDAO;
        this.orderShowDAO = orderShowDAO;
        this.ordersDAO = ordersDAO;
        this.ordersDishDAO = ordersDishDAO;
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

    @PostMapping("/add_order")
    public String add_order(@ModelAttribute("order") Orders order) {
        Date thisTime = java.sql.Date.valueOf(LocalDate.now());
        order.setDate(thisTime);
        order.setOrders_sum((double)0);

        ordersDAO.openOrder(order);
        return "meogol/order";
    }

    @GetMapping("/show_order/{id}")
    public String show_order(@PathVariable("id") int id, @ModelAttribute("newOd") OrdersDish newOD, Model model) {
        var order = ordersDAO.getById(id);
        model.addAttribute("order", order);
        model.addAttribute("od", ordersDishDAO.showAllOrders(order.getId()));
        model.addAttribute("dishes", dishDAO.index());

        newOD.setOrder(order);

        return "meogol/order";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("orders", ordersDAO.showAll());
        return "meogol/orders";
    }

    @DeleteMapping("/delete_od/{id}/{orderId}")
    public String remove_od(@PathVariable("id") int id, @PathVariable("orderId") int orderId) {
        ordersDishDAO.delete(id);
        return "redirect:/show_order/"+orderId;
    }

    @PostMapping("/add_order_dish/{orderId}")
    public String add_order_dish(@PathVariable("orderId") int orderId, @ModelAttribute("order_dish") OrdersDish od) {
        System.out.println("12354213"+od.toString());
        var order = new Orders();
        order.setId(orderId);
        
        od.setOrder(order);
        ordersDishDAO.add(od);

        return "redirect:/show_order/"+od.getOrder().getId();
    }
}
