package course.work.meogol.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "дата")
    private Date date;

    @Column(name = "счет")
    private Double order_summ;

    @Column(name = "цена")
    private Double price;

    @Column(name = "блюдо")
    private String dish;

    @Column(name = "количество")
    private int countDish;

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

    public Double getOrder_summ() {
        return order_summ;
    }

    public void setOrder_summ(Double order_summ) {
        this.order_summ = order_summ;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getCountDish() {
        return countDish;
    }

    public void setCountDish(int countDish) {
        this.countDish = countDish;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", order_summ=" + order_summ +
                ", price=" + price +
                ", dish='" + dish + '\'' +
                ", countDish=" + countDish +
                '}';
    }
}
