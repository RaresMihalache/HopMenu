package ro.sd.a2.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Review_restaurant")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class ReviewRestaurant {

    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @Column
    @NonNull
    private LocalDate date;

    @Column
    @NonNull
    private float score;

    @Column
    @NonNull
    private String details;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NonNull
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

}
