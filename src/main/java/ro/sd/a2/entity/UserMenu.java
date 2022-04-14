package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_menu")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class UserMenu {

    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @NonNull
    private Menu menu;
}
