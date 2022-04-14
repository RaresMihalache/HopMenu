package ro.sd.a2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTOs.UserDTO;
import ro.sd.a2.entity.User;
import ro.sd.a2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }


    public int login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null){
            System.out.println("Welcome " + email);
            return 1;
        }
        return -1;
    }

    public UserDTO findByEmail(String email){
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByEmail(email);
        if(user != null) {
            userDTO = userDTO.convertFromUserToUserDTO(user);
            return userDTO;
        }
        return null;
    }

    public String createUser(UserDTO newUserDTO){
        User newUser = new User();
        newUser = newUser.convertFromUserDTOToUser(newUserDTO);
        userRepository.save(newUser);
        return newUser.getId();
    }

    public String createUser(UserDTO newUserDTO, String confirmPassword){
        if(newUserDTO.getPassword().equals(confirmPassword) == false)
            return "-1"; // passwords don't match
        UserDTO checkEmail = findByEmail(newUserDTO.getEmail());
        if(checkEmail == null){
            User newUser = new User();
            newUser = newUser.convertFromUserDTOToUser(newUserDTO);
            userRepository.save(newUser);
            return "1"; // success -> account created successfully
        }
        return "-2"; // user with given email found
    }

}
