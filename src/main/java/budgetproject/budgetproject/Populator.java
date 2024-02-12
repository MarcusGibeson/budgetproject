package budgetproject.budgetproject;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Models.User;
import budgetproject.budgetproject.Services.BillService;
import budgetproject.budgetproject.Services.IncomeService;
import budgetproject.budgetproject.Services.UserService;

@Component
public class Populator implements CommandLineRunner{
    
    private final BillService billService;
    private final IncomeService incomeService;
    private final UserService userService;

    public Populator(BillService billService, IncomeService incomeService, UserService userService) {
        this.billService = billService;
        this.incomeService = incomeService;
        this.userService = userService;
    }

    LocalDate dueDateElectric = LocalDate.of(2024, 2, 15);
    LocalDate dueDateGas = LocalDate.of(2024, 2, 6);

    @Override
    public void run(String... args) throws Exception {
        
        //create populator here need bills, User, income, 

        User admin = new User("admin", "password");
        userService.registerUser(admin);

        Bill electric = new Bill("Electric", 85, dueDateElectric, admin);
        Bill gas = new Bill("Gas", 75, dueDateGas, admin);

        billService.save(electric);
        billService.save(gas);
    }
}
