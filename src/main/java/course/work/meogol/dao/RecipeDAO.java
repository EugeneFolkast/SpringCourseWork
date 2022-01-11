package course.work.meogol.dao;

import course.work.meogol.model.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RecipeDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public RecipeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Recipe> getRecipe(int dishId) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select r from Recipe r where r.dish.id = :dishId", Recipe.class)
                .setParameter("dishId", dishId)
                .getResultList();
    }
}
