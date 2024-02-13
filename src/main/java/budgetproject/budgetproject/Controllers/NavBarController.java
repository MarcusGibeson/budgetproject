package budgetproject.budgetproject.Controllers;


import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Models.User;
import budgetproject.budgetproject.Services.BillService;
import budgetproject.budgetproject.Services.IncomeService;
import budgetproject.budgetproject.Services.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NavBarController {
    
    @Resource
    private UserService userService;

    @Resource
    private BillService billService;

    @Resource 
    private IncomeService incomeService;

    public NavBarController(UserService userService, BillService billService, IncomeService incomeService) {
        this.userService = userService;
        this.billService = billService;
        this.incomeService = incomeService;
    }
    
    @GetMapping("/bills")
    public String showBills(Model model, HttpServletRequest request) throws Exception {
        long userId = userService.getUserId(request);
        User user = userService.getUserById(userId);

        Collection<Bill> userBills = user.getBills();
        
        model.addAttribute("user", user);
        model.addAttribute("bills", userBills);
        return "bills";
    }

    @GetMapping("/income")
    public String showIncome(Model model, HttpServletRequest request) throws Exception {
        long userId = userService.getUserId(request);
        User user = userService.getUserById(userId);

        model.addAttribute("user", user);
        model.addAttribute("incomes", incomeService.retrieveAllIncome());
        return "income";
    }
}
