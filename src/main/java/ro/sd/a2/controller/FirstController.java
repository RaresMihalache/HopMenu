package ro.sd.a2.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.setViewName("register");
        return mav;
    }

    /*
    @GetMapping("/profile")
    public ModelAndView showProfile() {
        //validation if needed
        //shall we log a little?
        ModelAndView mav = new ModelAndView();

        User user = new User("Bubu");
        mav.addObject("fullUserObj", user);
        mav.addObject("numeStudent", user.getName());
        // adaugi x obiecte
        mav.setViewName("profile");
        //log the final outcome: Success y?
        return mav;
    }*/


}
