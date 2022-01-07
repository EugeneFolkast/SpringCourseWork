package course.work.meogol.dao;

import course.work.meogol.model.OrderShow;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderShowDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderShowDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<OrderShow> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select od from OrderShow od", OrderShow.class)
                .getResultList();
    }

}
