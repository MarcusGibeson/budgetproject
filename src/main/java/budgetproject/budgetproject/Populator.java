package budgetproject.budgetproject;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Models.Income;
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

    //bills
    LocalDate dueDateElectric = LocalDate.of(2024, 2, 15);
    LocalDate dueDateGas = LocalDate.of(2024, 2, 6);
    LocalDate dueDateRent = LocalDate.of(2024,2,5);
    LocalDate dueDateCarPayment = LocalDate.of(2024, 2, 25);
    LocalDate dueDatePhone = LocalDate.of(2024,2,20);

    //income
    LocalDate datePaidTaxes = LocalDate.of(2024, 2, 12);
    LocalDate datePaidPaycheck = LocalDate.of(2024, 2, 16);
    LocalDate datePaidPaycheck2 = LocalDate.of(2024,3,1);

    @Override
    public void run(String... args) throws Exception {
        
        /*
         * Users
         */

        User admin = new User("admin", "password");
        userService.registerUser(admin);


        /*
         * Bills
         */

        Bill electric = new Bill("Electric", 240, dueDateElectric, admin);
        Bill gas = new Bill("Gas", 240, dueDateGas, admin);
        Bill rent = new Bill("Rent", 1100, dueDateRent, admin);
        Bill carPayment = new Bill("Car Payment", 394, dueDateCarPayment, admin);
        Bill phone = new Bill("Phone", 193, dueDatePhone, admin);


        billService.save(electric);
        billService.save(gas);
        billService.save(rent);
        billService.save(carPayment);
        billService.save(phone);

        /*
         * Income
         */

         Income taxes = new Income("Federal Taxes", 800 , dueDatePhone, admin);
         Income paycheck = new Income("Paycheck", 200, datePaidPaycheck, admin);
         Income paycheck2 = new Income("Paycheck 2", 450, datePaidPaycheck2, admin);

         incomeService.save(taxes);
         incomeService.save(paycheck);
         incomeService.save(paycheck2);

    }
}
