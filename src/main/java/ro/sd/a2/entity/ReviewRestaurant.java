package ro.sd.a2.entity;


import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Review_restaurant")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class ReviewRestaurant {

    @Id
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
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
