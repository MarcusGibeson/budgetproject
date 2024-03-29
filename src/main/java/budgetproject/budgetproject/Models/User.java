package budgetproject.budgetproject.Models;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    
    @OneToMany(mappedBy="user")
    private Collection<Bill> bills;

    @OneToMany(mappedBy="user")
    private Collection<Income> incomes;

    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Bill> getBills() {
        return bills;
    }

    public void setBills(Collection<Bill> bills) {
        this.bills = bills;
    }

    public Collection<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(Collection<Income> incomes) {
        this.incomes = incomes;
    }

    public double getTotalBillsAmount() {
        double totalAmount = 0.0;
        if (bills != null) {
            for (Bill bill : bills) {
                totalAmount += bill.getAmount();
            }
        }
        return totalAmount;
    }

    public double getTotalIncomeAmount() {
        double totalAmount = 0.0;
        if (incomes != null) {
            for (Income income : incomes) {
                totalAmount += income.getAmount();
            }
        }
        return totalAmount;
    }

    public double getDifferenceBetweenIncomeAndBills() {
        double totalBillAmount = getTotalBillsAmount();
        double totalIncomeAmount = getTotalIncomeAmount();
        double totalAmount = totalIncomeAmount - totalBillAmount; 
        return totalAmount;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        User other = (User) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", bills=" + bills + ", incomes=" + incomes
                + "]";
    }


}
