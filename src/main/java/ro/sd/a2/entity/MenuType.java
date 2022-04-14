package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menu_type")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MenuType {

    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @Column
    @NonNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MenuType_menu",
            joinColumns = @JoinColumn(name = "menu_type_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    @NonNull
    private List<Menu> menus;

}
