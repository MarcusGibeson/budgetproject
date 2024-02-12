package budgetproject.budgetproject.Repositories;

import org.springframework.data.repository.CrudRepository;

import budgetproject.budgetproject.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
