package budgetproject.budgetproject.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Income {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int amount;
    private LocalDate datePaid;
    
    public Income() {
    }

    public Income(String name, int amount, LocalDate datePaid) {
        this.name = name;
        this.amount = amount;
        this.datePaid = datePaid;
    }

    
}
