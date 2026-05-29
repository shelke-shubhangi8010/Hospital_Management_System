package com.hospital.Hospital_Management_System.Repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.Hospital_Management_System.Entity.User;

public interface UserRepository
        extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
    User findByUsernameAndPassword(String username,
            String password);
}