package budgetproject.budgetproject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    
}
