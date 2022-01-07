package course.work.evgenii.repository;

import course.work.evgenii.model.Employee;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface accessindata extends CrudRepository<Employee, Integer> {

}