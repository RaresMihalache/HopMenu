package ro.sd.a2.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "User_menu")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserMenu {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @org.springframework.lang.NonNull
    private Menu menu;
}
