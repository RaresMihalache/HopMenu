package ro.sd.a2.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.DTOs.UserDTO;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.RestaurantService;
import ro.sd.a2.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView loginForm(){

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView loginSubmit(@ModelAttribute User user){
        ModelAndView mav = new ModelAndView("home");
        User findUser = user;
        int success = userService.login(user.getEmail(), user.getPassword());
        if(success == 1){
            System.out.println("Success");
        }
        else{
            System.out.println("Error");
        }

        System.out.println(user.getEmail() + " " + user.getPassword());
        return mav;
    }

    @PostMapping("/registerUser")
    public ModelAndView registerSubmit(@ModelAttribute UserDTO newUserDTO,
                                       @RequestParam String confirmPass){
        ModelAndView mavSuccess = new ModelAndView("home");
        ModelAndView mavErrorEmail = new ModelAndView("errorEmail");
        ModelAndView mavErrorPass = new ModelAndView("errorPassword");

        String response = userService.createUser(newUserDTO, confirmPass);
        if (response.equals("-2")){
            System.out.println("Email already used.");
            return mavErrorEmail;
        }
        else if(response.equals("-1")){
            System.out.println("Passwords don't match");
            return mavErrorPass;
        }

        System.out.println("Account created successfully!");
        return  mavSuccess;
    }

    @GetMapping("/registerUser")
    public ModelAndView registerForm(){
        ModelAndView mav = new ModelAndView("registerUser");
        mav.addObject("newUserDTO", new UserDTO());
        mav.addObject("confirmPass", new String());
        return mav;
    }


    @GetMapping("/chooseRegisterEntity")
    public void chooseEntity(){

    }
}
