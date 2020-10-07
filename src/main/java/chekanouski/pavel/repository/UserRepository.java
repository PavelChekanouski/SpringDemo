package chekanouski.pavel.repository;

import chekanouski.pavel.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("update User set username = ?2, password = ?3 where id = ?1")
    void updateUserById(Long id, String username, String password);
}
