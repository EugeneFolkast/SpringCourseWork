package course.work.meogol.model;

import javax.persistence.*;
import java.util.Date;


@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name="add_order_dish",
                procedureName="add_order_dish",
                parameters={
                        @StoredProcedureParameter(name="input_dish_id", type=Integer.class, mode=ParameterMode.IN),
                        @StoredProcedureParameter(name="input_orders_id", type=Integer.class, mode=ParameterMode.IN),
                        @StoredProcedureParameter(name="input_count", type=Integer.class, mode=ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="update_order_dish",
                procedureName="update_order_dish",
                parameters={
                        @StoredProcedureParameter(name="input_id", type=Integer.class, mode=ParameterMode.IN),
                        @StoredProcedureParameter(name="input_count", type=Integer.class, mode=ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name="delete_order_dish",
                procedureName="delete_order_dish",
                parameters={
                        @StoredProcedureParameter(name="input_id", type=Integer.class, mode=ParameterMode.IN)
                }
        )
})
@Entity
@Table(name = "orders_dish")
public class OrdersDish {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders order;

    @Column(name = "count")
    private Integer count=1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrdersDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", order=" + order +
                ", count=" + count +
                '}';
    }
}
