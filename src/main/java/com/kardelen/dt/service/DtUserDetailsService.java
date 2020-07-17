package com.kardelen.dt.service;

import com.kardelen.dt.model.DtUserDetails;
import com.kardelen.dt.model.User;
import com.kardelen.dt.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */

@Service
public class DtUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + userName));

        return user.map(DtUserDetails::new).get();
    }
}
