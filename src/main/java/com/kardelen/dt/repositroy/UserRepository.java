package com.kardelen.dt.repositroy;

import com.kardelen.dt.model.Device;
import com.kardelen.dt.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
