package course.work.meogol.dao;

import course.work.meogol.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DishDAO  {

    private final SessionFactory sessionFactory;

    @Autowired
    public DishDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Dish> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select d from Dish d", Dish.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Dish show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Dish.class, id);
    }

    @Transactional
    public void save(Dish person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Dish updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Dish personToBeUpdated = session.get(Dish.class, id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setPrice(updatedPerson.getPrice());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Dish.class, id));
    }
}
