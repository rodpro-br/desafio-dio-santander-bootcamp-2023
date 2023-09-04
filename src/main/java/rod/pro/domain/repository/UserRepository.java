package rod.pro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rod.pro.domain.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
