package course.work.meogol.controller;

import course.work.meogol.dao.OrderShowDAO;
import course.work.meogol.dao.OrdersDishDAO;
import course.work.meogol.dao.RecipeDAO;
import course.work.meogol.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cook")
public class CookController {
    private final OrderShowDAO orderShowDAO;
    private final OrdersDishDAO ordersDishDAO;
    private final RecipeDAO recipeDAO;

    @Autowired
    public CookController(OrderShowDAO orderShowDAO, OrdersDishDAO ordersDishDAO, RecipeDAO recipeDAO) {
        this.orderShowDAO = orderShowDAO;
        this.ordersDishDAO = ordersDishDAO;
        this.recipeDAO = recipeDAO;
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

        return "redirect:/cook/cook_orders";
    }

    @GetMapping("/show_recipe/{id}")
    public String update_order_dish(@PathVariable("id") int id, Model model){
        List<Recipe> recipes = recipeDAO.getRecipe(id);
        model.addAttribute("recipes", recipes);

        return "meogol/recipe";
    }
}
