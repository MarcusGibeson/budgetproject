package budgetproject.budgetproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Models.Income;
import budgetproject.budgetproject.Models.LoginDto;
import budgetproject.budgetproject.Models.User;
import budgetproject.budgetproject.Services.BillService;
import budgetproject.budgetproject.Services.IncomeService;
import budgetproject.budgetproject.Services.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    
    @Resource
    private UserService userService;

    @Resource
    private BillService billService;

    @Resource 
    private IncomeService incomeService;
    
    public MainController(UserService userService, BillService billService, IncomeService incomeService) {
        this.billService = billService;
        this.userService = userService;
        this.incomeService = incomeService;
    }

    public User getUserFromRequest(HttpServletRequest request) throws Exception {
        long userId = userService.getUserId(request);
        if(userId == 0) {
            throw new Exception("Not logged in");
        }
        return userService.getUserById(userId);
        
    }

    @GetMapping({"","/","/login"})
    public String loginPage(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login"; 
    }

    /*  
     * Login control and cookie creation
     */

    @PostMapping("/loginUser")
    public String LoginUser(@ModelAttribute("loginDto") LoginDto login, HttpServletResponse response){
        User user = userService.getUserByUsername(login.getUsername());
        if(user == null){
            return "redirect:/";
        }

    //confirm password
    Cookie jwtTokenCookie = new Cookie("user-id", "" + user.getId());
    Cookie nameCookie = new Cookie("username","" + user.getUsername());
    response.addCookie(jwtTokenCookie);
    response.addCookie(nameCookie);
    return "redirect:/logon";
    }
    
    @GetMapping("/logon")
    public String homepage(Model model, HttpServletRequest request) throws Exception {
        User user = getUserFromRequest(request);
        model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        return "homepage";
    }

    /*
     * Delete cookie to log out
     */

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie jwtTokenCookie = new Cookie("user-id", null);
        Cookie nameCookie = new Cookie("username", null);
        nameCookie.setMaxAge(0);
        jwtTokenCookie.setMaxAge(0);
        response.addCookie(nameCookie);
        response.addCookie(jwtTokenCookie);
        return "login";
    }

    @PostMapping("/create-bill")
    public String createBill(@ModelAttribute Bill bill, Model model, HttpServletRequest request) throws Exception {
        User user = getUserFromRequest(request);
        bill.setUser(user);
        billService.save(bill);
        return "redirect:/logon";
    }
    
    @PostMapping("/create-income")
    public String createIncome(@ModelAttribute Income income, Model model, HttpServletRequest request) throws Exception {
        User user = getUserFromRequest(request);
        income.setUser(user);
        incomeService.save(income);
        return "redirect:/logon";
    }
}
