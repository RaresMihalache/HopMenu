package ro.sd.a2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

}
