package budgetproject.budgetproject.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int amount;
    private LocalDate dueDate;

    @ManyToOne
    private User user;

    public Bill () {

    }

    public Bill(String name, int amount, LocalDate dueDate, User user) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        this.user = user;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + amount;
        result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bill other = (Bill) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (amount != other.amount)
            return false;
        if (dueDate == null) {
            if (other.dueDate != null)
                return false;
        } else if (!dueDate.equals(other.dueDate))
            return false; 
        return true;
    }

    @Override
    public String toString() {
        return "Bill [name=" + name + ", amount=" + amount + ", dueDate=" + dueDate + ", user=" + user + "]";
    }


    
}
