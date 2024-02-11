package budgetproject.budgetproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import budgetproject.budgetproject.Services.BillService;

@Component
public class Populator implements CommandLineRunner{
    
    private final BillService billService;

    public Populator(BillService billService) {
        this.billService = billService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        //create populator here need bills, User, income, 
    }
}
