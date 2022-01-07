package course.work.meogol.dao;

import course.work.meogol.model.OrderShow;
import course.work.meogol.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class OrdersDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrdersDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Orders> showAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select d from Orders d", Orders.class)
                .getResultList();
    }

    @Transactional
    public void openOrder(){
        Date thisTime = java.sql.Date.valueOf(LocalDate.now());
        Session session = sessionFactory.getCurrentSession();

        session.save(new Orders(thisTime, (double) 0));
    }

}
