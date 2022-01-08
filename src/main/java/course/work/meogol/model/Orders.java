package course.work.meogol.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "orders_summ")
    private Double orders_sum;

    public Orders(Date date, Double orders_sum) {
        this.date = date;
        this.orders_sum = orders_sum;
    }

    public Orders() {

    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", orders_sum=" + orders_sum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOrders_sum() {
        return orders_sum;
    }

    public void setOrders_sum(Double orders_sum) {
        this.orders_sum = orders_sum;
    }
}
