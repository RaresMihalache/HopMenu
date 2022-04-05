package ro.sd.a2.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Review_menu")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class ReviewMenu {

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
    @JoinColumn(name = "menu_id")
    @NonNull
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

}
