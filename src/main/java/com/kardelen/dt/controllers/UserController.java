package com.kardelen.dt.controllers;

import com.kardelen.dt.constants.Command;
import com.kardelen.dt.model.User;
import com.kardelen.dt.service.DtUserDetailsService;
import com.kardelen.dt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.kardelen.dt.model.Device;

import java.util.Optional;


/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */



@Controller
//@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private DtUserDetailsService userService;

    @PostMapping(path="/updateuser")
    public @ResponseBody
    String updateUser (@RequestParam String userId, @RequestParam String username, @RequestParam String password) {



       return "User updated";
    }

    @PostMapping(path="/adduser/")
    public @ResponseBody
    String addUser (@RequestParam String username, @RequestParam String password) {
        System.out.println(username);
        if (userService.isExists(username)){
            System.out.println(" username exists");
            User user = userService.findUserByName(username).get();
            System.out.println("name found");

            user.setUserName(username);
            user.setPassword(password);
            user.setActive(true);

            userService.saveUser(user);


            return "updated";
        }
        else{
            System.out.println(" username not exists");
            // Add new device to DB
            User user = new User();

            user.setUserName(username);
            user.setPassword(password);
            user.setActive(true);
            user.setRoles("ROLE_USER");

            userService.saveUser(user);
            return "user added";
        }

    }

    @DeleteMapping(path="/deleteuser/")
    public @ResponseBody
    String deleteUser (@RequestParam String username) {
        System.out.println(username);
        if (userService.isExists(username)){
            System.out.println(" username exists");

            userService.deleteUser(username);


            return "updated";
        }
        else{
            System.out.println(" username not exists");

            return "user not exists";
        }

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUser() {
        // This returns a JSON or XML with the devices
        return userService.getUserList();
    }

}
