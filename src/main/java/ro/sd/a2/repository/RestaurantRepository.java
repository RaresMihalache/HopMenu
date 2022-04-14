package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    Restaurant findByEmail(String email);

    Restaurant findByEmailAndPassword(String email, String password);
}
