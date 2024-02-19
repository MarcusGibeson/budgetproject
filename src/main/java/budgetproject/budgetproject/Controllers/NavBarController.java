package budgetproject.budgetproject.Controllers;


import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Models.Income;
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

    private final MainController mainController;

    public NavBarController(UserService userService, BillService billService, IncomeService incomeService, MainController mainController) {
        this.userService = userService;
        this.billService = billService;
        this.incomeService = incomeService;
        this.mainController = mainController;
    }
    
    @GetMapping("/bills")
    public String showBills(Model model, HttpServletRequest request) throws Exception {
        User user = mainController.getUserFromRequest(request);
        Collection<Bill> userBills = user.getBills();
        
        model.addAttribute("user", user);
        model.addAttribute("bill", new Bill());
        model.addAttribute("bills", userBills);
        return "bills";
    }

    @GetMapping("/income")
    public String showIncome(Model model, HttpServletRequest request) throws Exception {
        User user = mainController.getUserFromRequest(request);
        Collection<Income> userIncomes = user.getIncomes();

        model.addAttribute("user", user);
        model.addAttribute("income", new Income());
        model.addAttribute("incomes", userIncomes);
        return "income";
    }
}
