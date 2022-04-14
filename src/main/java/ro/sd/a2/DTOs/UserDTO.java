package ro.sd.a2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sd.a2.entity.ReviewMenu;
import ro.sd.a2.entity.ReviewRestaurant;
import ro.sd.a2.entity.User;
import ro.sd.a2.entity.UserMenu;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String email;
    private String password;
    private List<UserMenu> menus;
    private ReviewMenu reviewMenu;
    private ReviewRestaurant reviewRestaurant;

    public UserDTO convertFromUserToUserDTO(User user){
        return UserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .menus(user.getMenus())
                .reviewMenu(user.getReviewMenu())
                .reviewRestaurant(user.getReviewRestaurant())
                .build();
    }

}
