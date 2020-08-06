package com.kardelen.dt.service;


import com.kardelen.dt.model.User;

import com.kardelen.dt.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public Iterable<User> getUserList(){
        return userRepository.findAll();
    }




    public boolean isExists(int userID){
        return userRepository.existsById(userID);
    }

    public  Optional<User> updateUser(int id, String username, String password){
        return userRepository.findById(id).map(target ->{
            target.setUserName(username);
            target.setPassword(password);

            userRepository.save(target);
            return target;
        });
    }

}
