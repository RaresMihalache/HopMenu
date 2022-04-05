package ro.sd.a2.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`User`")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

    @Id
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
}
