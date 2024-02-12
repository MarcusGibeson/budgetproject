package budgetproject.budgetproject.Services;

import org.springframework.stereotype.Service;

import budgetproject.budgetproject.Models.Income;
import budgetproject.budgetproject.Repositories.IncomeRepository;

@Service
public class IncomeService {
    
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @SuppressWarnings("null")
    public Income save(Income income){
        return incomeRepository.save(income);
    }

    @SuppressWarnings("null")
    public Income retrieveIncomeById(Long id) throws Exception {
        try{
            return incomeRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception("Income not found.");
        }
    }

    @SuppressWarnings("null")
    public void delete(Long id) throws Exception {
        if(!incomeRepository.existsById(id)) {
            throw new Exception("Income not found");
        }
    }

    
}
