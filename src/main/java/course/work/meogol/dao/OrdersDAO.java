package course.work.meogol.dao;

import course.work.meogol.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
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
    public void openOrder(Orders order){
        Session session = sessionFactory.getCurrentSession();

        session.save(order);
    }

    @Transactional
    public Orders getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Orders.class, id);
    }

    @Transactional
    public void deleteOrder(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Orders.class, id));
    }

}
