package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
