package budgetproject.budgetproject.Services;

import org.springframework.stereotype.Service;

import budgetproject.budgetproject.Models.User;
import budgetproject.budgetproject.Repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //fetch userId 
    public long getUserId(HttpServletRequest request) {
        long retValue = 0;
        Cookie[] cookies = request.getCookies();
        for(int x = 0; x < cookies.length; x++){
            if(cookies[x].getName().equals("user-id")){
                retValue = Long.parseLong(cookies[x].getValue());
                break;
            }
        }
        return retValue;
    }

    //user registration
    @SuppressWarnings("null")
    public void registerUser(User user) {
        userRepository.save(user);
    }

    //user retrieval
    public User getUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @SuppressWarnings("null")
    public User save(User user) {
        return userRepository.save(user);
    }
}
