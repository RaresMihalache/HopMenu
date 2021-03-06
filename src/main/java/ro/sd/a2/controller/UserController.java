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
import ro.sd.a2.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


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
