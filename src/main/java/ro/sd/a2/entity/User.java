package ro.sd.a2.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import ro.sd.a2.DTOs.UserDTO;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "`User`")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMenu> menus;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ReviewMenu reviewMenu;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ReviewRestaurant reviewRestaurant;


    public User convertFromUserDTOToUser(UserDTO userDTO){
        User newUser = User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .menus(userDTO.getMenus())
                .reviewMenu(userDTO.getReviewMenu())
                .reviewRestaurant(userDTO.getReviewRestaurant())
                .build();
        newUser.setId(UUID.randomUUID().toString());
        return newUser;
    }
}
