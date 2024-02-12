package budgetproject.budgetproject.Repositories;

import org.springframework.data.repository.CrudRepository;

import budgetproject.budgetproject.Models.Income;

public interface IncomeRepository extends CrudRepository<Income, Long> {
    
}
