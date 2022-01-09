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

    @Column(name = "status")
    private String status = "Готовится";

    public OrdersDish(Dish dish, Orders order, Integer count, String status) {
        this.dish = dish;
        this.order = order;
        this.count = count;
        this.status = status;
    }

    public OrdersDish(){}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", order=" + order +
                ", count=" + count +
                ", status='" + status + '\'' +
                '}';
    }
}
