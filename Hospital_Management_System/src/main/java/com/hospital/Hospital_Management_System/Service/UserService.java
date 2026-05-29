package com.hospital.Hospital_Management_System.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.User;
import com.hospital.Hospital_Management_System.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }
    
    public User login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}