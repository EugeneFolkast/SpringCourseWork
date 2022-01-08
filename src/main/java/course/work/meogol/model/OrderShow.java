package course.work.meogol.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "`order`")
public class OrderShow {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "дата")
    private Date date;

    @Column(name = "счет")
    private Double sum_price;

    @Column(name = "блюдо")
    private String name;

    @Column(name = "цена")
    private Double price;

    @Column(name = "количество")
    private Integer count;


    public OrderShow(Date date, Double sum_price, String name, Double price, Integer count) {
        this.date = date;
        this.sum_price = sum_price;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public OrderShow() {

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

    public Double getSum_price() {
        return sum_price;
    }

    public void setSum_price(Double sum_price) {
        this.sum_price = sum_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", date=" + date +
                ", sum_price=" + sum_price +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
