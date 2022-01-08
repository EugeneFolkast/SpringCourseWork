package course.work.meogol.dao;

import course.work.meogol.model.Orders;
import course.work.meogol.model.OrdersDish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import java.util.List;

@Component
public class OrdersDishDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrdersDishDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<OrdersDish> showAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select d from OrdersDish d", OrdersDish.class)
                .getResultList();
    }


    @Transactional(readOnly = true)
    public List<OrdersDish> showAllOrders(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select d from OrdersDish d where d.order.id = :id", OrdersDish.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();

        var call = session.createStoredProcedureCall("delete_order_dish");
        call.registerParameter("input_id", Integer.class, ParameterMode.IN).bindValue(id);
        call.getOutputs();
    }

    @Transactional
    public void add(OrdersDish od){
        Session session = sessionFactory.getCurrentSession();

        var call = session.createStoredProcedureCall("add_order_dish");
        call.registerParameter("input_dish_id", Integer.class, ParameterMode.IN).bindValue(od.getDish().getId());
        call.registerParameter("input_orders_id", Integer.class, ParameterMode.IN).bindValue(od.getOrder().getId());
        call.registerParameter("input_count", Integer.class, ParameterMode.IN).bindValue(od.getCount());
        call.getOutputs();
    }
}
