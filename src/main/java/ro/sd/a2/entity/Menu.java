package ro.sd.a2.entity;


import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Menu")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Menu {

    @Id
    private String id;

    @Column
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "menus")
    @NonNull
    private List<MenuType> menuTypes;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @NonNull
    private List<ReviewMenu> reviewMenus;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @NonNull
    private List<UserMenu> menus;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NonNull
    private Restaurant restaurant;


}
