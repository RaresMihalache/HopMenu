package ro.sd.a2.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menu_type")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class MenuType {

    @Id
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
