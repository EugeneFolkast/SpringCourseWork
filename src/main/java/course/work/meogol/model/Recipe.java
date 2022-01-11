package course.work.meogol.model;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public Recipe(Double amount, Dish dish, Ingredient ingredient) {
        this.amount = amount;
        this.dish = dish;
        this.ingredient = ingredient;
    }

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", amount=" + amount +
                ", dish=" + dish +
                ", ingredient=" + ingredient +
                '}';
    }
}