package budgetproject.budgetproject.Repositories;

import org.springframework.data.repository.CrudRepository;

import budgetproject.budgetproject.Models.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {
    Bill findById(long id);
    Bill findByName(String name);
}
