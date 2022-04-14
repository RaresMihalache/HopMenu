package ro.sd.a2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sd.a2.entity.Menu;
import ro.sd.a2.entity.Restaurant;
import ro.sd.a2.entity.ReviewRestaurant;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDTO {

    private String email;
    private String password;
    private String name;
    private String address;
    private String start_hour;
    private String end_hour;
    private List<ReviewRestaurant> reviews;
    private List<Menu> menus;

    public RestaurantDTO convertFromRestaurantToRestaurantDTO(Restaurant restaurant){
        return RestaurantDTO.builder()
                .email(restaurant.getEmail())
                .password(restaurant.getPassword())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .start_hour(restaurant.getStart_hour())
                .end_hour(restaurant.getEnd_hour())
                .reviews(restaurant.getReviews())
                .menus(restaurant.getMenus())
                .build();
    }
}
