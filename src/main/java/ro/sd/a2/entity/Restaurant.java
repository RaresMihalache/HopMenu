package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Restaurant")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Restaurant {

    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String address;

    @Column
    @NonNull
    private String start_hout;

    @Column
    @NonNull
    private String end_hour;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @NonNull
    private List<ReviewRestaurant> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @NonNull
    private List<Menu> menus;

}
