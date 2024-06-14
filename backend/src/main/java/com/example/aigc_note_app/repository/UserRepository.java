package main.java.com.example.aigc_note_app.repository;

import main.java.com.example.aigc_note_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
