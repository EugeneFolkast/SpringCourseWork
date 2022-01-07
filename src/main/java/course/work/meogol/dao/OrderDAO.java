package course.work.meogol.dao;

import course.work.meogol.model.Dish;
import course.work.meogol.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Order> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select o from Order o", Order.class)
                .getResultList();
    }
}
