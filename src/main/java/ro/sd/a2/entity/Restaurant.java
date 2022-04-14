package ro.sd.a2.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ro.sd.a2.DTOs.RestaurantDTO;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String address;

    @Column
    @NonNull
    private String start_hour;

    @Column
    @NonNull
    private String end_hour;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<ReviewRestaurant> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus;

    public Restaurant convertFromRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO){
        Restaurant newRestaurant = Restaurant.builder()
                .email(restaurantDTO.getEmail())
                .password(restaurantDTO.getPassword())
                .name(restaurantDTO.getName())
                .address(restaurantDTO.getAddress())
                .start_hour(restaurantDTO.getStart_hour())
                .end_hour(restaurantDTO.getEnd_hour())
                .reviews(restaurantDTO.getReviews())
                .menus(restaurantDTO.getMenus())
                .build();
        newRestaurant.setId(UUID.randomUUID().toString());
        return newRestaurant;
    }
}
