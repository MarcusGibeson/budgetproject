package budgetproject.budgetproject.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Income {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int amount;
    private LocalDate datePaid;
    
    @ManyToOne
    private User user;

    public Income() {
    }

    public Income(String name, int amount, LocalDate datePaid, User user) {
        this.name = name;
        this.amount = amount;
        this.datePaid = datePaid;
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

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
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
        result = prime * result + ((datePaid == null) ? 0 : datePaid.hashCode());
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
        Income other = (Income) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (amount != other.amount)
            return false;
        if (datePaid == null) {
            if (other.datePaid != null)
                return false;
        } else if (!datePaid.equals(other.datePaid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Income [name=" + name + ", amount=" + amount + ", datePaid=" + datePaid + ", user=" + user + "]";
    }



    
}
